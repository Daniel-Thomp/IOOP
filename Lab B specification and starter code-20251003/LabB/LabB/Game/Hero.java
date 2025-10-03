package Game;
public class Hero {
    private String name;
    private String skill;

    Hero(String name){
        this.name = name;
        skill = "None";
    }

    public void printDetails() {
        Book.printHelper(new String[]{"Title:     " + name, "Skill:   " + skill});

    }

    public void useSkill(String skillName){
        if (skill.equals(skillName)) {
            System.out.println(name + " used " + skillName);
        } else {
            System.out.println(name + " does not know " + skillName);
        }
    }

    public void readBook(Book book){
        System.out.println(name + " read " + book.getTitle() + "\n" + name + " forgot " + skill + "\n" + name + " learned " + book.getSkill());
        skill = book.getSkill();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
    
}
