package learn.solarFarm.data;

import learn.solarFarm.models.Materials;
import learn.solarFarm.models.SolarPanel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SolarPanelFileRepository implements SolarPanelRepository {


    private final String filePath;

    public SolarPanelFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<SolarPanel> findAll() throws DataAccessException {
        ArrayList<SolarPanel> result = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] fields = line.split(",");
                if (fields.length == 7) {
                    SolarPanel solarPanel = new SolarPanel();
                    solarPanel.setPanelId(Integer.parseInt(fields[0]));
                    solarPanel.setSection(Integer.parseInt(fields[1]));
                    solarPanel.setRow(Integer.parseInt(fields[2]));
                    solarPanel.setColumn(Integer.parseInt(fields[3]));
                    solarPanel.setMaterial(Materials.valueOf(fields[4]));
                    solarPanel.setYear(Integer.parseInt(fields[5]));
                    solarPanel.setTrackable(fields[6].equals("true"));
                    result.add(solarPanel);
                }
            }
        } catch (FileNotFoundException ex){

        } catch (IOException ex) {
            throw new DataAccessException(ex.getMessage());
        }
        return result;
    }

    @Override
    public SolarPanel findById (int solarPanelId) throws DataAccessException {
        for(SolarPanel solarPanel: findAll()){
            if(solarPanel.getPanelId() == solarPanelId) {
                return solarPanel;
            }
        }
        return null;
    }

    @Override
    public List<SolarPanel> findBySection(int section) throws DataAccessException {
        ArrayList<SolarPanel> result = new ArrayList<>();
        for(SolarPanel solarPanel: findAll()) {
            if(solarPanel.getSection() == section) {
                result.add(solarPanel);
            }
        }
        return result;
    }

    @Override
    public SolarPanel add(SolarPanel solarPanel) throws DataAccessException {
        List<SolarPanel> all = findAll();

        int nextId = 0;
        for(SolarPanel s: all){
            nextId = Math.max(nextId, s.getPanelId());
        }
        nextId++;
        solarPanel.setPanelId(nextId);

        all.add(solarPanel);
        writeAll(all);

        return solarPanel;
    }

    @Override
    public boolean update(SolarPanel solarPanel) throws DataAccessException {
        List<SolarPanel> all = findAll();
        for(int i= 0; i < all.size() ; i++) {
            if(all.get(i).getPanelId() == solarPanel.getPanelId()){
                all.set(i,solarPanel);
                writeAll(all);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(int PanelId) throws DataAccessException {
        List<SolarPanel> all = findAll();
        for(int i= 0; i <all.size(); i++) {
            if(all.get(i).getPanelId() == PanelId){
                all.remove(i);
                writeAll(all);
                return true;
            }
        }
        return false;
    }

    private void writeAll(List<SolarPanel> solarPanels) throws DataAccessException {
        try(PrintWriter writer = new PrintWriter((filePath))) {
            writer.println("panelId,section,row,column,material,year,trackable;");
            for(SolarPanel s: solarPanels){
                writer.println(serialize(s));
            }
        } catch (IOException ex){
            throw new DataAccessException(ex.getMessage());
        }
    }


    private String serialize(SolarPanel solarPanel){
        return String.format("%s,%s,%s,%s,%s,%s,%s,",
                solarPanel.getPanelId(),
                solarPanel.getSection(),
                solarPanel.getRow(),
                solarPanel.getColumn(),
                solarPanel.getMaterial(),
                solarPanel.getYear(),
                solarPanel.isTrackable());
    }

}