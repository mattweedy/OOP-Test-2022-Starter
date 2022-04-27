package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
    // create new arraylist of nematodes
    ArrayList<Nematode> nematodes = new ArrayList<Nematode>();
    public float border;

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
		}		
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();
        loadNematodes();		
	}
	

	public void loadNematodes()
	{
        Table table = loadTable("data/nematodes.csv", "header");
        for(TableRow r:table.rows())
        {
            Nematode nema = new Nematode(r);
            nematodes.add(nema);
            System.out.println(nema.toString());
        }
	}

    public void drawNematode() {
        // looping through each nematode and calling it to render
        for (Nematode n : nematodes) {
            n.render(this);
        }
    }

	public void draw()
	{
        // calling drawNematode
        drawNematode();
	}
}
