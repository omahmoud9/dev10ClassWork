public class Exercise14 {
    public static void main(String[] args) {
        int gradeLevel = 12;
        boolean isSenior = gradeLevel >= 12;
        boolean isInterestedInVolunterring = false;
        boolean shouldSendVolunteerInfo = isSenior && isInterestedInVolunterring;
        System.out.println(shouldSendVolunteerInfo);
    }
}
