(ns haunted.commands.basic
  (require [haunted.util :as util]))

(defn go [input game-state]
  (when (#{"n" "s" "e" "w" "up" "down" "enter" "ne" "nw" "se" "sw"} input)
    (println "You can't move yet.")
    game-state))

(defn quit [input game-state]
  (when (#{"q" "quit"} input)
    (assoc game-state :running? false)))