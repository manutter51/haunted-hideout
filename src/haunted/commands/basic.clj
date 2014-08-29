(ns haunted.commands.basic
  (require [haunted.util :as util]
           [clojure.string :as str]))

(defn look [cmd game-state]
  (when (= :LOOK (first cmd))
    (util/look-room game-state)))

(defn quit [cmd game-state]
  (when (= :QUIT (first cmd))
    (assoc game-state :running? false)))