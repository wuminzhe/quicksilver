(ns quicksilver.core
  (:require [clojurewerkz.meltdown.reactor :as mr]
            [clojurewerkz.meltdown.selectors :refer [$]])
  (:gen-class))

(defn -main
  [& args]
  (let [reactor (mr/create)]
    (mr/on reactor ($ "key")
      (fn [event]
        (comment "Do something here")))))

(mr/notify reactor "key" {:my "payload"})
