(ns haunted.rooms
  (:require [haunted.rooms.outside :as outside]))

(defn init []
  (-> {}
    (outside/add-rooms)))
