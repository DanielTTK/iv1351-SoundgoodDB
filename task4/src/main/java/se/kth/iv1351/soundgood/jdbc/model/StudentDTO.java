package se.kth.iv1351.soundgood.jdbc.model;

public interface StudentDTO {
    /**
     * @return students id.
     */
    public String getStudentID();

    /**
     * @return students personal id.
     */
    public String getPersonID();

    /**
     * @return students skill level.
     */
    public String getSkillLevel();
}
