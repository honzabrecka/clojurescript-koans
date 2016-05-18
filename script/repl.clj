(use 'figwheel-sidecar.repl-api)

(def server-port 3450)
(def build-id "dev")

(def config (-> (figwheel-sidecar.config/fetch-config)
                (merge {:figwheel-options {:server-port server-port}})
                (update :all-builds #(vec (filter (fn [build] (= (:id build) build-id)) %)))
                (assoc :build-ids [build-id])))

(start-figwheel! config)
(cljs-repl)
