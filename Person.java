/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaWorkExercises;

/**
 *
 * @author Beren
 */
public class Person implements java.io.Serializable{
    private String ID;
    private String Name;
    private String Job_title;
    private String DOB;
    private String[] Appearance;
    private String Phone_number;
    private String Height;
    private String Hair_Colour;
    private String Eye_Colour;
    private String Gender;

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Job_title
     */
    public String getJob_title() {
        return Job_title;
    }

    /**
     * @param Job_title the Job_title to set
     */
    public void setJob_title(String Job_title) {
        this.Job_title = Job_title;
    }

    /**
     * @return the DOB
     */
    public String getDOB() {
        return DOB;
    }

    /**
     * @param DOB the DOB to set
     */
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    /**
     * @return the Appearance
     */
    public String[] getAppearance() {
        return Appearance;
    }

    /**
     * @param Appearance the Appearance to set
     */
    public void setAppearance(String[] Appearance) {
        this.setAppearance(Appearance);
    }

    /**
     * @return the Phone_number
     */
    public String getPhone_number() {
        return Phone_number;
    }

    /**
     * @param Phone_number the Phone_number to set
     */
    public void setPhone_number(String Phone_number) {
        this.Phone_number = Phone_number;
    }

    /**
     * @param Appearance the Appearance to set
     */
    /**
     * @return the Height
     */
    public String getHeight() {
        return Height;
    }

    /**
     * @param Height the Height to set
     */
    public void setHeight(String Height) {
        this.Height = Height;
    }

    /**
     * @return the Hair_Colour
     */
    public String getHair_Colour() {
        return Hair_Colour;
    }

    /**
     * @param Hair_Colour the Hair_Colour to set
     */
    public void setHair_Colour(String Hair_Colour) {
        this.Hair_Colour = Hair_Colour;
    }

    /**
     * @return the Eye_Colour
     */
    public String getEye_Colour() {
        return Eye_Colour;
    }

    /**
     * @param Eye_Colour the Eye_Colour to set
     */
    public void setEye_Colour(String Eye_Colour) {
        this.Eye_Colour = Eye_Colour;
    }

    /**
     * @return the Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * @param Gender the Gender to set
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    
}
