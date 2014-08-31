(ns haunted.rooms.outside
  (:require [haunted.util :refer [room-builder]]))

(def weeds-details "The weeds are thick, discolored, and strangely misshapen. In the fitful glare of the flickering lightning, they
                     almost seem to be crawling slowly across the ground. But that's just your imagination. Of course it is.")
(def trees-details "They say plants sometimes have feelings. You decide you'd rather not know what these trees are feeling. Whatever it is, it ain't good.")

(def stones-details "There is a small pile of stones here, each just the right size for throwing. Spattered randomly
                     on the stones is what appears to be dried blood. Quite a lot of it, in fact.")

(def add-rooms
  (room-builder
    "Outside Rooms"
    {
      :outs-front-yard
      {
        :short    "Front yard"
        :long     "You are in an overgrown front yard filled with weeds, brambles, and gnarled, leafless trees. To the west
               is a large, grey house with a boarded-up front door, a sagging roof, creepy windows, and a porch that
               slopes to one side, as though the foundations were crumbling away beneath it. The yard continues around
               to the north and south. A large, rusty, iron gate bars the way to the west."
        :visible { "gate" "The gate looks like something that might have been stolen from Stephen King by a mad scientist
                           with a teleportation beam that twisted things through an abnormal number of dimensions. Despite
                           its contorted structure, however, it looks distressingly solid and immovable. In the center is
                           a large lock, shaped like the head of some kind of archean Lovecraftian monster."
                   "lock" "The jaws of this lizard-like head are open just wide enough that some foolish adventure would be
                           able to stick his or her hand between them, assuming they didn't care whether they ever got it
                           back again. Apparently the keyhole is inside the mouth."
                   "weeds" weeds-details
                   "house" "If you were going to steal Stephen King's gate, this is probably the house you'd put it in front
                            of. You'd probably hide some kind of nasty surprise under the floorboards of that rickety old
                            porch, too. Oddly, the windows are all dark. In fact, the darkness seems to be seeping out of
                            them, and dripping down the side of the house. Probably just a weird trick of the light, due
                            to the heavy rain and irregular lightning."
                   "foundations" "Yep, those are some seriously crumbly-looking foundations there. You sure wouldn't want to risk
                                  your life by going inside that house. No sirree."
                   "window" "Each window looks pretty much the same as all the others, except the broken window."
                   "broken window" "Oddly, though the house looks long-abandoned, only one window is broken, as though whoever had
                                    thrown the stone had decided quite suddenly not to throw any more."
                   "stones" stones-details
                   "rocks" stones-details
                   "pile" stones-details
                   "pile of stones" stones-details
                   "pile of rocks" stones-details
                   "yard" "The yard is neglected and overgrown, with only a small pile of stones to show where a driveway might once have been."
                   }
        :go-north :outs-north-yard
        :go-south :outs-south-yard
        :go-east  :outs-porch
        :go-west  "The large iron gate is closed and locked."
        :outside? true}

      :outs-north-yard
      {
        :short    "Side yard (north)"
        :long     "You are in what might once have been a garden. The thick weeds are lined up in more or less regular
               clumps, kinda, and there's a birdbath in the center, although the bowl has fallen over and broken
               into two large, upside-down chunks at the base of the pedestal. A large grey house is to your south
               and the yard continues back around to the west. Tall brick walls prevent you from going any farther
               north or east."
        :visible { "garden" "There is no garden here. Maybe there used to be, but not now."
                   "weeds" weeds-details
                   "birdbath" "A simple, concrete birdbath. There's a broken-off chunk at the top, which is why the bowl fell off."
                   "bowl" "The bowl is upside-down on the dirt, and split into two large chunks. One of them has a trail of slime across it--two inches wide."
                   "house" "Looking at the house from the north, you think of words with \"oo\" in them, like brooding, and looming. Or maybe doom."
                   "walls" "The walls are rain-slicked and unclimbable. They bulge and lean drunkenly, as though about to collapse, yet paradoxically
                            seem solid and immovable enough to repel a bulldozer attack."
                   "bricks" "The bricks are unusually large and heavy, and criss-crossed with trails of slime, each one about 2 inches wide. At first
                             glance, they seem perfectly uniform, with clean lines and sharp 90 degree angles. From the corner of your eye, though,
                             the lines seem to sway and ripple, as though the lines you see are not the true shape of the bricks."
                   "yard" "This yard is an unkempt mess. It's probably been decades since anybody kempt it."
                   }
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
        :visible { "brambles" "The brambles are woven and tangled, and remind you oddly of how a spider might build a nest. A big spider."
                   "thorns" "The thorns are the strangest you've ever seen, with hooks pointing opposite directions, to catch you no matter which way you go."
                   "nettles" "Thin and almost transparent, you're most likely to feel the nettles before you see them. You'll feel them very clearly, though. Ouch."
                   "trees" trees-details
                   "fence" "The fence is iron spikes an inch thick and 12 feet tall, with sharp, barbed needlepoints for tips. Here and there, some kind of
                            weird, coppery sludge is oozing out of tiny corrosions on the iron, almost as if it were bleeding. Very peculiar."
                   "sludge" "Oozing out of the spikes on the fence, the sludge has a curiously dry appearance, despite the rain streaming down the fence.
                             The shape looks rather fungal and scabrous, and you wouldn't want to touch it."
                   "branch" "Each branch looks pretty much the same as the others, which is to say wretched, deformed, and almost malignant."
                   "branches" "The branches are trembling in the heavy downpour, which gives them the appearance of a certain predatory eagerness."
                   }
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