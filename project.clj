(defproject koans "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :profiles {:dev
    {:dependencies [[specljs "2.9.1"]]}}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [prismatic/dommy "0.1.2"]
                 [jayq "2.5.4"]
                 [figwheel-sidecar "0.5.0-1"]]

  :plugins [[lein-cljsbuild "1.1.2"]
            [specljs "2.9.1"]]

  :source-paths ["script"]
  :test-paths ["spec"]

  :cljsbuild { :builds [{:id "dev"
                         :source-paths ["src"]
                         :figwheel {:load-warninged-code true}
                         :compiler {:main koans.core
                                    :output-to "koans.js"
                                    :output-dir "out/dev"
                                    :optimizations :none}}
                        {:id "prod"
                         :source-paths ["src"]
                         :compiler {
                                    :main koans.core
                                    :output-to "koans.js"
                                    :output-dir "out/prod"
                                    :optimizations :none
                                    :source-map true}}]
              })
