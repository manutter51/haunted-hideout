(ns haunted.core
  (require [haunted.util :as util]
           [haunted.rooms :as rooms]
           [haunted.commands :as cmd]
           [clojure.string :as str]
           [clojure.tools.nrepl.server :as repl]))

(defonce repl (repl/start-server :port 7888))

(def debug-state (atom nil))                                ; for use by repl

(def prompt "::> ")

(def splash-msg "
Welcome to Haunted Hideout.

You were driving down a long, dark road during a gully-washing thunderstorm, when a strange
mist drifted across the road. You remember slowing down due to the reduced visibility, and
then there was some kind of large, nearly-human shape lumbering across the road, and you
swerved...

It's still a bit vague. Apparently there was an accident... you have half a memory of slogging
through rain and and branches towards a distant light, like a candle in a window. And now you're
here.

Wherever here is.")

(defn get-input [& prompt]
  (when-let [p (first prompt)]
    (print p)
    (flush))
  (read-line))

(defn init-game-state []
  {:running? true
   :location :outs-front-yard
   :inventory []
   :rooms (rooms/init)
   :visited? #{}
   :commands (cmd/init)})

;; Stole this pattern from Erlang: instead of storing game state in a global
;; mutable var or atom, just keep passing it back in as the arg to the main
;; loop fn.
(defn main-loop [game-state]
  (when (:running? game-state)
    (reset! debug-state game-state)
    (recur (cmd/handle (str/lower-case (get-input prompt)) game-state))))

(defn -main [& args]
  (println "\n")
  (println (util/trim-long splash-msg))
  (println)
  (main-loop (init-game-state))
  (repl/stop-server repl)
  (shutdown-agents))
