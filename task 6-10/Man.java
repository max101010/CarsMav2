/**
 * this s class for the task 7.
 */
public class Man {

    /**
     * id number for the instance Man.
     */
    private int id;
    /**
     * name for the instance Man.
     */
    private String name;
    /**
     * age for the instance Man.
     */
    private int age;
    /**
     * sex for the instance Man.
     */
    private String sex;

    /**
     * gets Id.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * gets name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * gets age.
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * gets sex.
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * constructor for the class Man.
     * @param id man
     * @param name man
     * @param age man
     * @param sex man
     */
    public Man(int id, String name, int age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;


    }
}
