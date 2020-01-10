package com.apcsa.data;

public class QueryUtils {

    /////// QUERY CONSTANTS ///////////////////////////////////////////////////////////////

    /*
     * Determines if the default tables were correctly loaded.
     */

    public static final String SETUP_SQL =
        "SELECT COUNT(name) AS names FROM sqlite_master " +
            "WHERE type = 'table' " +
        "AND name NOT LIKE 'sqlite_%'";

    /*
     * Updates the last login timestamp each time a user logs into the system.
     */

    public static final String LOGIN_SQL =
        "SELECT * FROM users " +
            "WHERE username = ?" +
        "AND auth = ?";

    /*
     * Updates the last login timestamp each time a user logs into the system.
     */

    public static final String UPDATE_LAST_LOGIN_SQL =
        "UPDATE users " +
            "SET last_login = ? " +
        "WHERE username = ?";

    /*
     * Updates the password of a user.
     */

    public static final String UPDATE_PASSWORD_SQL =
    		"UPDATE users "
    		+ "SET auth = ? " +
    		"WHERE username = ?";

    /*
     * Retrieves an administrator associated with a user account.
     */

    public static final String GET_ADMIN_SQL =
        "SELECT * FROM administrators " +
            "WHERE user_id = ?";

    /*
     * Retrieves a teacher associated with a user account.
     */

    public static final String GET_TEACHER_SQL =
        "SELECT * FROM teachers " +
            "WHERE user_id = ?";

    public static String GET_TEACHER_FROM_ID = 
    "SELECT * FROM TEACHERS " +
    	"WHERE teacher_id = ?";
    
    public static String GET_DEPARTMENT_BY_ID = 
    "SELECT * FROM DEPARTMENTS " +
    	"WHERE DEPARTMENT_ID = ?";
    
    public static String GET_ENROLLMENT_SQL = 
    "SELECT * FROM STUDENTS";
    
    public static String GET_USERS_FROM_USERNAME = 
    "SELECT * FROM USERS " +
    "WHERE username = ?";
    
    public static String GET_ENROLLMENT_FROM_ID =
    "SELECT * FROM STUDENTS " + 
    	"WHERE STUDENT_ID = ?";
    
    public static String GET_TEACHER_BY_DEPARTMENT_SQL =
    "SELECT * FROM TEACHERS " + 
    	"WHERE DEPARTMENT_ID = ?";
    
    public static final String GET_DEPARTMENTS_SQL =
    "SELECT * FROM DEPARTMENTS";
    
    public static final String GET_TEACHER_IDS_SQL =
    "SELECT * FROM TEACHERS";
    
    public static final String GET_ENROLLMENT_BY_GRADE =
    "SELECT * FROM STUDENTS " +
    	"WHERE GRADE_LEVEL = ?";
    
    public static final String GET_ENROLLMENT_WITH_COURSE_NO = 
    "SELECT * FROM COURSES " +
    	"WHERE COURSE_NO = ?";
    
    public static final String GET_ASSIGNMENT_GRADES_FROM_STUDENT_ID_AND_COURSE_ID =
    "SELECT * FROM ASSIGNMENT_GRADES " +
    	"WHERE COURSE_ID = ?" + 
    	"AND STUDENT_ID = ?";
    
    public static final String GET_COURSE_GRADES_FROM_COURSE_IDS =
    "SELECT * FROM COURSE_GRADES " +
    	"WHERE COURSE_ID = ?";
    
    public static final String GET_COURSES_FROM_STUDENT_ID =
    "SELECT * FROM COURSE_GRADES " +
    	"WHERE STUDENT_ID = ?";
    
    public static final String GET_STUDENT_ID_FROM_USER_ID =
    "SELECT * FROM STUDENTS " +
    	"WHERE USER_ID = ?";
    
    public static final String GET_USERS_WITH_USERNAME = 
    "SELECT * FROM USERS " +
    	"WHERE USERNAME = ?";
    
    public static final String GET_COURSES_FROM_COURSE_ID = 
    "SELECT * FROM COURSES " +
    	"WHERE COURSE_ID = ?";
    
    public static final String TEACHER_VIEW_ENROLLMENT = 
    "SELECT STUDENTS.first_name, STUDENTS.last_name, COURSE_GRADES.grade FROM COURSE_GRADES " +
    	"INNER JOIN STUDENTS ON COURSE_GRADES.STUDENT_ID=STUDENTS.STUDENT_ID"
    	+ " WHERE COURSE_ID = ?";

    public static final String GET_TEACHER_ID_FROM_USER_ID =
    	"SELECT TEACHERS.TEACHER_ID FROM TEACHERS "
    	+ "WHERE USER_ID = ?";
    
    public static final String GET_COURSE_TITLES = 
    "SELECT COURSES.COURSE_NO, COURSES.COURSE_ID FROM COURSES "
    + "WHERE TEACHER_ID = ?";
    		
    public static final String GET_COURSES_FROM_TEACHER_ID = 
    "SELECT * FROM COURSES " +
    	"WHERE TEACHER_ID = ?";
    
    public static final String GET_COURSE_GRADES_FROM_STUDENT_ID = 
    "SELECT * FROM COURSE_GRADES " +
    	"WHERE STUDENT_ID = ?";
    /*
     * Retrieves a student associated with a user account.
     */

    public static final String GET_STUDENT_SQL =
        "SELECT * FROM students " +
            "WHERE user_id = ?";

    public static String GET_FACULTY =
        "SELECT users.user_id, account_type, username, auth, last_login, teacher_id, first_name, last_name, title, teachers.department_id " +
            "FROM teachers " +
            "INNER JOIN users ON teachers.user_id=users.user_id " +
            "INNER JOIN departments " +
            "ON teachers.department_id=departments.department_id";

    public static String GET_STUDENTS = 
    "SELECT last_name, first_name, graduation, student_id, class_rank, grade_level, gpa, users.user_id, account_type, username, auth, last_login " +
        "FROM students INNER JOIN users ON users.user_id = students.user_id ORDER BY last_name";

    public static String GET_DEPARTMENTS =
        "SELECT '[' || department_id || '] ' || title || '.' \"Phrase\" FROM departments ORDER BY department_id;";

    public static String GET_FACULTY_BY_DEPT =
    "SELECT last_name || ', ' || first_name || ' / ' || departments.title \"Phrase\" FROM teachers " +
        "INNER JOIN departments ON teachers.department_id=departments.department_id WHERE departments.department_id = ? ORDER BY last_name";

    public static String GET_STUDENT_ENROLLMENT_BY_COURSE_NO =
    "SELECT DISTINCT grade, course_no, course_grades.student_id \"STUDENT_ID\", course_grades.course_id, first_name, last_name, graduation FROM courses " +
        "INNER JOIN course_grades ON courses.course_id = course_grades.course_id " +
        "INNER JOIN students ON students.student_id = course_grades.student_id WHERE course_no = ?";

    public static String GET_STUDENT_COURSES =
    "SELECT courses.title, grade, courses.course_no FROM course_grades " +
        "INNER JOIN courses ON course_grades.course_id = courses.course_id " +
        "INNER JOIN students ON students.student_id = course_grades.student_id " +
        "WHERE students.student_id = ?";

    public static String GET_ASSIGNMENT_GRADES_BY_COURSE_STUDENT =
    "SELECT * FROM course_grades " +
        "INNER JOIN courses ON course_grades.course_id = courses.course_id " +
        "INNER JOIN students ON students.student_id = course_grades.student_id " +
        "WHERE students.student_id = ?";

    public static String GET_TEACHER_COURSES =
        "SELECT * FROM teachers INNER JOIN courses ON teachers.teacher_id = courses.teacher_id WHERE teachers.teacher_id = ?";

    public static String GET_STUDENT_ENROLLMENT_BY_COURSE_ID =
    "SELECT * FROM students LEFT OUTER JOIN course_grades ON students.student_ID = course_grades.student_id INNER JOIN courses ON courses.course_id = course_grades.course_id OUTER LEFT JOIN users ON users.user_id = students.student_id WHERE courses.course_id = ?";

}
