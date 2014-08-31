(ns haunted.util
  (:require [clojure.set :as set]
            [clojure.string :as str]
            [instaparse.core :as insta]))

(def wrapper (insta/parser (clojure.java.io/resource "word-wrapper.bnf")))

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

(defn- make-wrapping-blocks [s]
  (let [trimmed (str/replace s #"(?:^|\n)[ \t]+" "\n")
        blocks (wrapper trimmed)]
    (when (insta/failure? blocks)
      (throw (Exception. "Failed to parse string for word-wrap.")))
    (map #(str/join " " %)
         (map rest blocks))))

(defn wrapped [s limit]
  (loop [todo (re-seq #"[^ ]+" s)
         out ""
         len 0]
    (if (nil? (seq todo))
      out
      (let [word (first todo)
            remaining (rest todo)
            word-len (inc (.length word))]
        (if (> (+ len word-len) limit)
          (recur remaining (str out "\n" word " ") word-len)
          (recur remaining (str out word " ") (+ len word-len)))))))

(defn wrap
  "Wrap a string to a given width (default 112 columns)."
  ([s]
   (wrap s 112))
  ([s limit]
   (str/join "\n\n" (map #(wrapped % limit) (make-wrapping-blocks s)))))

(defn trim-long [description]
  (wrap description))

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

(defn examine [obj game-state]
  (let [rm (current-room game-state)
        vis (:visible rm)
        details (get vis obj)]
    (if (nil? details)
      (println "Nothing to see here, move along.")
      (println (wrap details))))
  game-state)
