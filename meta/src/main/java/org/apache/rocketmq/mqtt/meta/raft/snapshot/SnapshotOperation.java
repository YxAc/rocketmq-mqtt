/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rocketmq.mqtt.meta.raft.snapshot;

import com.alipay.sofa.jraft.storage.snapshot.SnapshotReader;
import com.alipay.sofa.jraft.storage.snapshot.SnapshotWriter;

import java.util.function.BiConsumer;

public interface SnapshotOperation {

    /**
     * do snapshot save operation.
     *
     * @param writer      {@link Writer}
     * @param callFinally Callback {@link BiConsumer} when the snapshot operation is complete
     */
    void onSnapshotSave(SnapshotWriter writer, BiConsumer<Boolean, Throwable> callFinally);

    /**
     * do snapshot load operation.
     *
     * @param reader {@link Reader}
     * @return operation label
     */
    boolean onSnapshotLoad(SnapshotReader reader);
}
