(ns haunted.commands
  (require [haunted.util :as util]
           [instaparse.core :as insta]
           [haunted.commands.basic :as basic]
           [haunted.commands.move :as move]))

(def parse (insta/parser (clojure.java.io/resource "parser.bnf")))

(defn handle [input game-state]
  (let [ast (parse input)
        ;; comes back as a vec inside a seq; we want vec, so extract
        ast (first ast)]
    (prn ast)
    (if (insta/failure? ast)
      (do (println "Speak up, I can't hear you.")
          game-state)
      (or (some #(% ast game-state) (:commands game-state))
          (do
            (println "Huh?")
            game-state)))))

(defn init []
  [basic/look
   basic/examine
   basic/quit
   move/move])