import java.util.Random;

public class RoomAllotment {

    public static void main(String[] args) {

        int totalStudents = 21;
        int totalRooms = 10;

        // 2D array:
        // 10 rows = 10 rooms
        // 2 columns = maximum 2 students in each room
        int[][] rooms = new int[totalRooms][2];

        // Array containing student numbers from 1 to 21
        int[] students = new int[totalStudents];

        for (int i = 0; i < totalStudents; i++) {
            students[i] = i + 1;
        }

        Random random = new Random();

        // Shuffle students randomly
        // This makes the allotment different every time
        for (int i = totalStudents - 1; i > 0; i--) {

            int j = random.nextInt(i + 1);

            int temp = students[i];
            students[i] = students[j];
            students[j] = temp;
        }

        // Put the first 20 students into 10 rooms
        for (int i = 0; i < 20; i++) {

            int roomNumber = i / 2;
            int position = i % 2;

            rooms[roomNumber][position] = students[i];
        }

        // The 21st student will be in waiting
        int waitingStudent = students[20];

        // Display room allotment
        System.out.println("Random Room Allotment");
        System.out.println("---------------------");

        for (int i = 0; i < totalRooms; i++) {

            System.out.print("Room " + (i + 1) + ": ");

            for (int j = 0; j < 2; j++) {
                System.out.print("Student " + rooms[i][j] + " ");
            }

            System.out.println();
        }

        // Display waiting student
        System.out.println("\nWaiting Student: Student " + waitingStudent);
    }
}