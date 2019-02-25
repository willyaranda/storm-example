package com.formacionhadoop.storm.example.bolts;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

import java.util.Map;

public class EnhanceBookBolt extends BaseRichBolt {
    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        // TODO: we should connect to an external DB here that can give us information about the book
        // from the BOOK element
    }

    @Override
    public void execute(Tuple tuple) {
        // TODO: let's try to get the BOOK name, and search in an external database
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        // TODO: emit a new Values: BookName, AuthorName, YearPublishing
    }
}
