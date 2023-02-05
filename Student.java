import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {

  String surname;
  String initials;
  int group;
  int[] academicPerformance;

  public Student(String surname, String initials, int group, int[] academicPerformance) {
    this.surname = surname;
    this.initials = initials;
    this.group = group;
    this.academicPerformance = academicPerformance;
  }

  @Override
  public String toString() {
    return "Student{" +
        "surname='" + surname + '\'' +
        ", initials='" + initials + '\'' +
        ", group=" + group +
        ", academicPerformance=" + Arrays.toString(academicPerformance) +
        '}';
  }

  public static void main(String[] args) {
    Student[] students = new Student[10];

    students[0] = new Student("Daniels", "TS", 1, new int[]{7, 7, 7, 8, 9});
    students[1] = new Student("Mcclain", "JJ", 1, new int[]{9, 9, 9, 10, 10});
    students[2] = new Student("Barr", "KB", 2, new int[]{8, 8, 8, 7, 7});
    students[3] = new Student("Boyd", "CA", 2, new int[]{6, 6, 5, 4, 6});
    students[4] = new Student("Anderson", "MR", 2, new int[]{9, 9, 10, 9, 10});
    students[5] = new Student("Osborn", "JK", 2, new int[]{7, 8, 7, 8, 7});
    students[6] = new Student("Herring", "KK", 3, new int[]{7, 8, 9, 7, 8});
    students[7] = new Student("Knight", "ML", 3, new int[]{9, 9, 9, 10, 10});
    students[8] = new Student("Hardy", "ME", 3, new int[]{5, 6, 5, 6, 5});
    students[9] = new Student("Hart", "NG", 3, new int[]{9, 9, 9, 10, 10});

    Student[] excellentStudents = findExcellentStudents(students);

    for (Student student : excellentStudents) {
      System.out.println(student);
    }
  }

  private static Student[] findExcellentStudents(Student[] students) {
    List<Student> result = new ArrayList<>();

    for (Student student : students) {
      if (isExcellentStudent(student)) {
        result.add(student);
      }
    }

    return result.toArray(new Student[0]);
  }

  private static boolean isExcellentStudent(Student student) {
    for (int grade : student.academicPerformance) {
      if (grade < 9) {
        return false;
      }
    }

    return true;
  }
}