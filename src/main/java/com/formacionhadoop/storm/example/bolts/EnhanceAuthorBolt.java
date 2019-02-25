package com.formacionhadoop.storm.example.bolts;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

import java.util.Map;

public class EnhanceAuthorBolt extends BaseRichBolt {
    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        // TODO: connect to an external DB and get more information about the Author
    }

    @Override
    public void execute(Tuple tuple) {
        // TODO: get the info for the author!
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        // TODO: emit a new Values: BookName, AuthorName, AuthorDOB, AuthorNationality, YearPublishing
    }
}
