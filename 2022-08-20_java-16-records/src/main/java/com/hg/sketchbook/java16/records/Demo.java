package com.hg.sketchbook.java16.records;

public class Demo {

  public static void main(String[] args) {

    var value = new PositiveInteger(10);

    System.out.println(value);

    var pair = new Pair<>("Left", "Right");

    System.out.println(pair);
    System.out.println(pair.left());
    System.out.println(pair.right());

  }
}
