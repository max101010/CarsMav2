/**
 * this is helper class for the task 14.
 */
public class Man {

    /**
     * the age for the instance of class Man.
     */
    private int age;
    /**
     * the name for the instance of class Man.
     */
    private String name;

    /**
     * the sex for the instance of class Man.
     */
    private String sex;

    /**
     * this is constructor for class Man.
     * @param age of Man
     * @param name of Man
     * @param sex of Man
     */
    public Man(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    /**
     * gets age.
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * gets name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * gets sex.
     * @return sex
     */
    public String getSex() {
        return sex;
    }

}
