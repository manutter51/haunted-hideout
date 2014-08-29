(ns haunted.rooms.outside
  (:require [haunted.util :refer [room-builder]]))

(def add-rooms
  (room-builder
    "Outside Rooms"
    {
      :outs-front-yard
      {
        :short    "Front yard"
        :long     "You are in an overgrown front yard filled with weeds, brambles, and gnarled, leafless trees.
               To the west is a large, grey house with boarded-up windows, a sagging roof, and a porch that
               slopes to one side, as though the foundations are crumbling away beneath it. The yard continues
               around to the north and south. A large, rusty, iron gate bars the way to the west."
        :go-north :outs-north-yard
        :go-south :outs-south-yard
        :go-east  :outs-porch
        :go-west  "The large iron gate is closed."
        :outside? true}

      :outs-north-yard
      {
        :short    "Side yard (north)"
        :long     "You are in what might once have been a garden. The thick weeds are lined up in more or less regular
               clumps, kinda, and there's a birdbath in the center, although the bowl has fallen over and broken
               into two large, upside-down chunks at the base of the pedestal. A large grey house is to your south
               and the yard continues back around to the west. Tall brick walls prevent you from going any farther
               north or east."
        :go-west  :outs-front-yard
        :outside? true}

      :outs-south-yard
      {
        :short    "Side yard (south)"
        :long     "You have pushed your way through brambles and stinging nettles to find yourself in even more brambles
               and stinging nettles. That and lots of blackened, twisted, ugly trees. Did you even know trees could
               grow thorns? These are ugly, twisted trees with great big honking thorns, for Pete's sake. The brambles
               are somewhat less tangled back to the west, and a tall iron fence is slowly being strangled by big,
               thorny tree branches to the south. You know there is a large house to the north, but the trees are
               so thick here it's kind of hard to see."
        :go-north "The trees and brambles are too dense to go in that direction."
        :go-south "The trees and brambles are too dense to go in that direction."
        :go-east  "The trees and brambles are too dense to go in that direction."
        :go-west  :outs-front-yard
        :outside? true}

      :outs-porch
      {
        :short    "Rickety front porch"
        :long     "This place will do something interesting soon. Exit west."
        :go-west  :outs-front-yard
        :outside? false }
      }))