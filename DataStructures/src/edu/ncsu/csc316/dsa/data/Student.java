package edu.ncsu.csc316.dsa.data;

import java.util.Objects;

/**
 * A student is comparable and identifiable.
 * Students have a first name, last name, id number, 
 * number of credit hours, gpa, and unityID.
 *
 * @author Dr. King
 */

public class Student implements Comparable<Student>, Identifiable {
  /** First name of student. */
  String first;
  /** Last name of student. */
  String last;
  /** Id of student. */
  int id;
  /** Amount of credit hours student has. */
  int creditHours;
  /** Student gpa. */
  double gpa;
  /* UnityId of student. */
  String unityId;

  /**
   * Creates a student object with student information.

   * @param first name of student
   * @param last name of student
   * @param id of student
   * @param creditHours credit hours of student
   * @param gpa of student
   * @param unityId unityId of student
   */
  public Student(String first, String last, int id, int creditHours, double gpa, 
      String unityId) {
    this.first = first;
    this.last = last;
    this.id = id;
    this.creditHours = creditHours;
    this.gpa = gpa;
    this.unityId = unityId;
  }

  /**
 * Gets the first name of the student.
 *
 * @return the first
*/
  public String getFirst() {
    return first;
  }


  /**
 * Sets the first name of the student.
 *
 * @param first the first to set
 */
  public void setFirst(String first) {
    this.first = first;
  }


  /**
 * Gets the last name of the student.
 *
 * @return the last
 */
  public String getLast() {
    return last;
  }


  /**
  * Sets the last name of the student.
  *
  * @param last the last to set
  */
  public void setLast(String last) {
    this.last = last;
  }


  /**
 * Gets the id of the student.
 *
 * @return the id
 */
  public int getId() {
    return id;
  }


  /**
 * Sets the id of the student.
 *
 * @param id the id to set
 */
  public void setId(int id) {
    this.id = id;
  }


  /**
 * Gets the number of credit hours the student has.
 *
 * @return the creditHours
 */
  public int getCreditHours() {
    return creditHours;
  }


  /**
 * Sets the amount of credit hours the student has.
 *
 * @param creditHours the creditHours to set
 */
  public void setCreditHours(int creditHours) {
    this.creditHours = creditHours;
  }


  /**
 * Gets the student gpa.
 *
 * @return the gpa
 */
  public double getGpa() {
    return gpa;
  }


  /**
 * Sets the students gpa.
 *
 * @param gpa the gpa to set
 */
  public void setGpa(double gpa) {
    this.gpa = gpa;
  }


  /**
 * Gets the unityID of the student.
 *
 * @return the unityID
 */
  public String getUnityId() {
    return unityId;
  }


  /**
  * Sets the unityID of the student.
  *
 * @param unityId the unityID to set
 */
  public void setUnityId(String unityId) {
    this.unityId = unityId;
  }

  /**
 * Returns the has code of the student.
 *
 * @return hashCode
 */
  @Override
  public int hashCode() {
    return Objects.hash(first, last, id);
  }

  /**
 * Returns true if students have same first name last name and id.
 *
 * @return true if same first, last, and id
 */
  @Override
public boolean equals(Object obj) {
	if(obj != null) {
	    Student stu = (Student) obj;
	    return (this.first.equals(stu.getFirst()) && this.last.equals(stu.getLast()));
	}
	return false;
  }

  /**
 * Compares two students natural ordering based on last name, first name, and student id.
 *
 * @param o Student being compared
 */
  @Override
public int compareTo(Student o) {
    //compare last name
    if (this.last.compareTo(o.getLast()) == 0) {
      //compare first name
      if (this.first.compareTo(o.getFirst()) == 0) {
        //compare id
        return Integer.valueOf(this.id).compareTo(Integer.valueOf(o.getId()));
      } else {
        return this.first.compareTo(o.getFirst());
      }
    } else {
      return this.last.compareTo(o.getLast());
    }
  }

  /**
 * Returns a string of the students first, last, then id.
 *
 * @return first last id
 */
  @Override
public String toString() {
    return first + " " + last + " " + id;
  }

}
