(ns haunted.commands
  (require [haunted.util :as util]
           [haunted.commands.basic :as basic]))

(defn handle [input game-state]
  (or (some #(% input game-state) (:commands game-state))
    (do
      (println "Huh?")
      game-state)))

(defn init []
  [basic/go
   basic/quit])