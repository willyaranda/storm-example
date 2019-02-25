package com.formacionhadoop.storm.example;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.generated.StormTopology;
import picocli.CommandLine;

@CommandLine.Command(name = "storm-example", mixinStandardHelpOptions = true, version = "storm-example 1.0")
class Topology implements Runnable {

    @CommandLine.Option(required=true, names = {"-e", "--environment"}, description = "How to run this: ${COMPLETION-CANDIDATES} (default: ${DEFAULT-VALUE})")
    Environment environment = Environment.local;
    private StormTopology topology;
    private String topologyName;
    private Config config;

    public Topology() {

    }

    private StormTopology configureTopology() {
        // TODO: here we should create the topology
        // Think about spouts, bolts and other things needed
        return null;
    }

    private Config getConfiguration() {
        Config c = new Config();
        c.put(Constants.NUM_RECORDS_TO_EMIT, 10);
        return c;
    }

    private void startTopology() throws InvalidTopologyException, AuthorizationException, AlreadyAliveException {
        if (environment.equals(Constants.LOCAL_MODE)) {
            LocalCluster lc = new LocalCluster();
            lc.submitTopology(topologyName, this.config, this.topology);
        } else {
            StormSubmitter.submitTopology(topologyName, this.config, this.topology);
        }
    }

    @Override
    public void run() {
        try {
            this.topology = configureTopology();
            this.config = getConfiguration();
            startTopology();
        } catch (InvalidTopologyException | AuthorizationException | AlreadyAliveException e) {
            e.printStackTrace();
        }
    }

    enum Environment {local, cluster}

}
