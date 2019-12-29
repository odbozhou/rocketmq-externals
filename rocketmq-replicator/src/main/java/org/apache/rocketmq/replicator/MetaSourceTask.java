/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.replicator;

import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.data.SourceDataEntry;
import io.openmessaging.connector.api.source.SourceTask;
import java.util.Collection;
import org.apache.rocketmq.replicator.common.Utils;
import org.apache.rocketmq.replicator.config.ConfigUtil;
import org.apache.rocketmq.replicator.config.TaskConfig;
import org.apache.rocketmq.replicator.offset.OffsetSyncStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetaSourceTask extends SourceTask {

    private static final Logger log = LoggerFactory.getLogger(RmqSourceTask.class);

    private final String taskId;
    private final TaskConfig config;
    private volatile boolean started = false;

    private OffsetSyncStore store;

    public MetaSourceTask() {
        this.config = new TaskConfig();
        this.taskId = Utils.createTaskId(Thread.currentThread().getName());
    }

    @Override public void start(KeyValue config) {
        ConfigUtil.load(config, this.config);
        this.started = true;
    }

    @Override public void stop() {
        if (started) {
            started = false;
        }
    }

    @Override public void pause() {

    }

    @Override public void resume() {

    }

    @Override public Collection<SourceDataEntry> poll() {
        return null;
    }
}
