(ns haunted.util
  (:require [clojure.set :as set]
            [clojure.string :as str]))

(defn room-builder [room m1]
  (fn [m2]
    (let [k1 (keys m1)
          k2 (keys m2)
          conflicts (set/intersection (set k1) (set k2))]
      (when (not= #{} conflicts)
        (throw (Exception. (apply str "Room conflict in room " room
                             ": already defined key(s) "
                             (str/join ", " (map name conflicts))))))
      (merge m1 m2))))
