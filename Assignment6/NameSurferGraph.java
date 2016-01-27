/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes
 * or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		initColors();
		update();
		addComponentListener(this);
	}
	
	private void initColors() {
		colors = new ArrayList<Color>();
		colors.add(Color.BLACK);
		colors.add(Color.RED);
		colors.add(Color.BLUE);
		colors.add(Color.MAGENTA);
	}

	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		Iterator<NameSurferEntry> it = entries.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
		update();
	}
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		entries.add(entry);
		update();
	}
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		removeAll();
		drawGraph();
		drawEntries();
	}
	
	private void drawGraph() {
		for (int i = 0; i < NDECADES; i++) {
			add(new GLine(getWidth() / NDECADES * i, 0,
					getWidth() / NDECADES * i, getHeight()));
			
			GLabel year = new GLabel("" + (1900 + i * 10));
			add(year, getWidth() / NDECADES * i + 3,
					getHeight() - (GRAPH_MARGIN_SIZE - year.getAscent()) / 2);
		}
		add(new GLine(0, GRAPH_MARGIN_SIZE, getWidth(), GRAPH_MARGIN_SIZE));
		add(new GLine(0, getHeight() - GRAPH_MARGIN_SIZE, getWidth(), getHeight() - GRAPH_MARGIN_SIZE));
	}

	private void drawEntries() {
		Iterator<NameSurferEntry> it = entries.iterator();
		Iterator<Color> colorIt = colors.iterator();
		while (it.hasNext()) {
			NameSurferEntry entry = it.next();
			if (colorIt.hasNext()) {
				current = colorIt.next();
			} else {
				colorIt = colors.iterator();
				current = colorIt.next();
			}
			
			for (int i = 0; i < NDECADES; i++) {
				drawSegment(entry, i);
			}
		}
	}

	private void drawSegment(NameSurferEntry entry, int decade) {
		int rank = entry.getRank(decade);
		GOval point = new GOval(DOT_SIZE, DOT_SIZE);
		point.setColor(current);
		point.setFilled(true);
		
		GLabel info = new GLabel(entry.getName() + " " + ((rank == 0) ? "*" : rank));
		info.setColor(current);
		
		double posX = getPosX(decade);
		double posY = getPosY(rank);
		
		if (decade < NDECADES - 1) {
			double nextX = getPosX(decade + 1);
			double nextY = getPosY(entry.getRank(decade + 1));
			GLine line = new GLine(posX, posY, nextX, nextY);
			line.setColor(current);
			add(line);
		}
		add(point, posX - point.getWidth() / 2, posY - point.getHeight() / 2);
		add(info, posX, posY);
	}
	
	private double getPosX(int decade) {
		return getWidth() / NDECADES * decade;
	}
	
	private double getPosY(int rank) {
		double posY = getHeight() - GRAPH_MARGIN_SIZE;
		if (rank > 0) {
			posY = GRAPH_MARGIN_SIZE + (posY - GRAPH_MARGIN_SIZE) / MAX_RANK * rank;
		}
		return posY;
	}

	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
	
	Color current;
	ArrayList<Color> colors;
	private ArrayList<NameSurferEntry> entries = new ArrayList<NameSurferEntry>();
}
