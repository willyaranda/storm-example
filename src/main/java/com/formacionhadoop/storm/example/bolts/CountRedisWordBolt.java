package com.formacionhadoop.storm.example.bolts;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

import java.util.Map;

public class CountRedisWordBolt extends BaseRichBolt {
    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        // TODO: connect to redis!
    }

    @Override
    public void execute(Tuple tuple) {
        // TODO: call redis each time a tuple is seen and increment the counter for that word
        // hint: use a INCR command https://redis.io/commands/incr
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        // TODO: mmm, should we do something here? I don't think so!
    }
}
