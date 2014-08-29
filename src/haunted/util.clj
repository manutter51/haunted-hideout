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

(defn trim-long [description]
  (str/join "\n" (map str/trim (re-seq #".*\n?" description))))

(defn current-room [game-state]
  (let [loc (or (:location game-state)
                (throw (Exception. "Illegal location error")))
        room (get-in game-state [:rooms loc] nil)]
    (when (nil? room)
      (throw (Exception. (str "Room not found for key " loc))))
    room))

(defn look-room [game-state]
  (let [rm (current-room game-state)]
    (println (trim-long (:long rm)))
    game-state))

(defn quick-look-room [game-state]
  (let [rm (current-room game-state)]
    (println (trim-long (:short rm)))
    game-state))