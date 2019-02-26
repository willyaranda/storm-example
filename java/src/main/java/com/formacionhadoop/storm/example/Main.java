package com.formacionhadoop.storm.example;

import picocli.CommandLine;

public class Main {
    public static void main(final String[] args) {
        CommandLine.run(new Topology(), args);
    }
}