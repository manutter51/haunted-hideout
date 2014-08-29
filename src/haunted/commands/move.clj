(ns haunted.commands.move
  (:require [haunted.util :as util]
            [clojure.string :as str]))

(defn do-move [new-room game-state]
  (if (nil? new-room)
    (do (println "You can't go that way.")
        game-state)
    (let [visited? (:visited? game-state)
          return-visit? (visited? new-room)
          new-visited (conj visited? new-room)
          game-state (assoc game-state :visited? new-visited :location new-room)]
      (if return-visit?
        (util/quick-look-room game-state)
        (util/look-room game-state)))))

(defn do-move-str [dir-str game-state]
  (println (util/trim-long dir-str))
  game-state)

(defn move [cmd game-state]
  (when (= :MOVE (first cmd))
    (let [dir-clause (rest cmd)
          dir (ffirst dir-clause)
          dir-key (keyword (str "go-" (str/lower-case (name dir))))
          rm (util/current-room game-state)
          new-room (get rm dir-key)]
      (cond
        (fn? new-room) (new-room dir-key game-state)
        (string? new-room) (do-move-str new-room game-state)
        :else (do-move (get rm dir-key) game-state)))))

