package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

// Matthew Tweedy
// C20381946

public class Nematode {
    String name;
    float length;
    int limbs;
    String gender;
    int eyes;

    public Nematode(String name, float length, int limbs, String gender, int eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    public Nematode(TableRow tr) {
        this(
            tr.getString("name"),
            tr.getFloat("length"),
            tr.getInt("limbs"),
            tr.getString("gender"),
            tr.getInt("eyes")
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public int getLimbs() {
        return limbs;
    }

    public void setLimbs(int limbs) {
        this.limbs = limbs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getEyes() {
        return eyes;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }

    public void render(NematodeVisualiser pa)
	{
        float halfW = pa.width/2;
        float halfH = pa.height/2;
        float offset = 45; // offset amount for drawing segments

        // printing names
        pa.textSize(20);
        pa.fill(255);
        pa.textAlign(PApplet.CENTER, PApplet.CENTER);
        pa.text(name, halfW, halfH - 200);
        pa.strokeWeight(5);

        // setting up vars to string compare for gender
        String male = "m";
        String female = "f";
        String hermaph = "h";

        for (int i = 0; i < this.length; i++) {
            pa.fill(0);
            pa.stroke(255);
            pa.circle(halfW, (halfH)+(offset*i), 45);

            // limbs
            if (this.limbs == 1) {
                pa.stroke(255);
                pa.line((halfW)+25, (halfH)+(offset*i), (halfW)+45, (halfH)+(offset*i));
                pa.line((halfW)-25, (halfH)+(offset*i), (halfW)-45, (halfH)+(offset*i));
            }
            // gender
            if (this.gender.compareTo(male) == 0) {
                pa.line(halfW, (halfH)+(offset*(this.length-1)+25), halfW, (halfH)+(offset*(this.length-1)+40));
                pa.circle(halfW, (halfH)+(offset*(this.length-1)+45), 15);
            } else if (this.gender.compareTo(female) == 0) {
                pa.circle(halfW, (halfH)+(offset*(length-1)), 15);
            } else if (this.gender.compareTo(hermaph) == 0) {
                pa.line(halfW, (halfH)+(offset*(this.length-1)+25), halfW, (halfH)+(offset*(this.length-1)+40));
                pa.circle(halfW, (halfH)+(offset*(this.length-1)+45), 15);
                pa.circle(halfW, (halfH)+(offset*(length-1)), 15);
            }

            // eyes
            if (this.eyes == 1) {
                pa.line(halfW+15, (halfH)-(offset-25), halfW+30, (halfH)-(offset));
                pa.line(halfW-15, (halfH)-(offset-25), halfW-30, (halfH)-(offset));
                pa.circle((halfH)-(offset-15), (halfH)-(offset), 15);
                pa.circle((halfH)-(offset-75), (halfH)-(offset), 15);
            }

        }

        

        
    }

}
