package learn.venus.data;

import learn.venus.models.Orbiter;
import learn.venus.models.OrbiterType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrbiterFileRepositoryTest {

    private OrbiterFileRepository repository = new OrbiterFileRepository("./data/orbiters.csv");

    @Test
    void shouldFindFiveOrbiters(){
        List<Orbiter> actual = repository.findAll();
        assertNotNull(actual);
        assertEquals(5,actual.size());
    }

    @Test
    void shouldFindExistingOrbiter(){
        Orbiter omar = repository.findById(4);
        assertNotNull(omar);
        assertEquals("Omar Mahmoud", omar.getName());

    }

    @Test
    void shouldNOTFindExistingOrbiter(){
        Orbiter nope = repository.findById(10000);
        assertNull(nope);

    }

    @Test
    void shouldFindOneOfEachType(){
        List<Orbiter> modules = repository.findByType((OrbiterType.MODULE));
        assertNotNull(modules);
        assertEquals(1,modules.size());

        List<Orbiter> modulesWithDocks = repository.findByType((OrbiterType.MODULE_WITH_DOCK));
        assertNotNull(modulesWithDocks);
        assertEquals(1,modulesWithDocks.size());

        List<Orbiter> shuttles = repository.findByType((OrbiterType.SHUTTLE));
        assertNotNull(shuttles);
        assertEquals(1,shuttles.size());

        List<Orbiter> astronauts = repository.findByType((OrbiterType.ASTRONAUT));
        assertNotNull(astronauts);
        assertEquals(1,astronauts.size());

        List<Orbiter> venushians = repository.findByType((OrbiterType.VENUSIAN));
        assertNotNull(venushians);
        assertEquals(1,venushians.size());
    }

}