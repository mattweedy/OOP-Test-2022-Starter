package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

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
        // pa.fill(255);
        // pa.textSize(50);
        // pa.textAlign(PApplet.CENTER, PApplet.CENTER);
        // pa.text(name, pa.width / 2, pa.height - (pa.border * 0.5f));

        pa.stroke(255, 0, 255);
        pa.textAlign(PApplet.CENTER, PApplet.CENTER);
        pa.textSize(20);
        float offset = 50; // offset amount for drawing segments

        // printing names
        pa.textAlign(PApplet.CENTER, PApplet.CENTER);
        pa.text(this.name, 50, 50);

        for (int i = 0; i < this.length; i++) {
            pa.fill(0);
            pa.stroke(255, 255, 255);
            pa.circle(pa.width/2, (pa.height/2)+(offset*i), 50);
        }
        

        if (this.gender == "m") {
            for (int i = 0; i < this.length; i++) {
            }
        } else if (this.gender == "f") {
            for (int i = 0; i < this.length; i++) {
            }
        } else if (this.gender == "h") {
            for (int i = 0; i < this.length; i++) {
            }
        } else if (this.gender == "n") {
            for (int i = 0; i < this.length; i++) {
            }
        }
        
    }

}
