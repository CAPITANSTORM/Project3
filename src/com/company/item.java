/*
Chase Alexander
Project 3
5/11/21
 */

package com.company;

public class item implements Comparable<item> {
    private String title;
    private String description;
    private Integer priority;
    static int numItems = 0;



    public item() {
        numItems++;
    }

    public item(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        numItems++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


    @Override
    public String toString() {
        return "Name: " + title + ", Description: " + description + ", Priority: " + priority + "\n";
    }

    public void display() {
        System.out.printf("Title: %s | Description: %s | Priority: %d", title, description, priority);
    }

    @Override
    public int compareTo(item other) {
        int compareResult = this.title.compareTo(other.title); // By itself sorts it alphabetically
        compareResult = this.priority.compareTo(other.priority); // By itself (overrides since it's written last) sorts priority highest to lowest
        return compareResult;
    }


}