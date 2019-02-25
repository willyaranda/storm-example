package com.formacionhadoop.storm.example.spouts;

import com.formacionhadoop.storm.example.Constants;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;

import java.util.Map;

public class RandomWordSpout extends BaseRichSpout {
    private Map config;
    private TopologyContext context;
    private SpoutOutputCollector collector;

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.config = map;
        this.context = topologyContext;
        this.collector = spoutOutputCollector;
    }

    @Override
    public void nextTuple() {
        // TODO: check how many tuples we need to emit
        // And emit a random truple with the word, the page and the book.
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields(Constants.WORD, Constants.PAGE, Constants.BOOK));
    }
}
