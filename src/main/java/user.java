import java.util.Objects;

public class user {

    private String user;

    private String password;

    private String Name;

    private int age;

    private boolean isMale;

    private double weight;

    private double height;

    private boolean isActive;

    public user(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public user(String user, String password, String name, int age, boolean isMale, double weight, double height, boolean isActive) {
        this.user = user;
        this.password = password;
        Name = name;
        this.age = age;
        this.isMale = isMale;
        this.weight = weight;
        this.height = height;
        this.isActive = isActive;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMale() {
        return isMale;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public boolean isActive() {
        return isActive;
    }

    public double getBmi(){
        return (this.weight / (this.height * this.height));
    }

    public double getHeightCM(){return this.height * 100;}

    public double getBmr(){
        if (this.isMale){
            return ((10 * this.weight) + (6.25 * this.getHeightCM()) - (5 * this.age) + 5);
        }
        return ((10 * this.weight) + (6.25 * this.getHeightCM()) - (5 * this.age) -161);
    }



    public double getTdee(){
        return this.getBmr() * this.getActivityMultiplier();
    }

    private double getActivityMultiplier() {
        if (isActive){return 1.725;}
        return 1.375;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        user user1 = (user) o;
        return age == user1.age && isMale == user1.isMale && Double.compare(weight, user1.weight) == 0 && Double.compare(height, user1.height) == 0 && isActive == user1.isActive && Objects.equals(user, user1.user) && Objects.equals(password, user1.password) && Objects.equals(Name, user1.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password, Name, age, isMale, weight, height, isActive);
    }

    public String toCSV() {
        return user + "," + password + "," + Name + "," + age + "," + isMale + "," + weight + "," + height + "," + isActive;
    }

    @Override
    public String toString() {
        return "user{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", Name='" + Name + '\'' +
                ", age=" + age +
                ", isMale=" + isMale +
                ", weight=" + weight +
                ", height=" + height +
                ", isActive=" + isActive +
                '}';
    }
}
