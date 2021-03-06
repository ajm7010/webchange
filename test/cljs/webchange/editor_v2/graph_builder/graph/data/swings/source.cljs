(ns webchange.editor-v2.graph-builder.graph.data.swings.source)

(def data {:assets        [{:url "/raw/img/park/swings/background.jpg", :size 10 :type "image"}
                           {:url "/raw/img/park/swings/swings.png", :size 1, :type "image"}
                           {:url "/raw/img/park/swings/tree.png", :size 1, :type "image"}

                           {:url "/raw/audio/english/l1/a3/mari.m4a", :size 2, :type "audio" :alias "mari" :target "mari"}
                           {:url "/raw/audio/english/l1/a3/vera.mp3", :size 2, :type "audio" :alias "vera" :target "vera"}
                           {:url "/raw/audio/english/l1/a3/vera-squirrel.mp3", :size 2, :type "audio" :alias "vera squirrel" :target "vera"}
                           {:url "/raw/audio/english/l1/a3/vera-elephant.mp3", :size 2, :type "audio" :alias "vera elephant" :target "vera"}
                           {:url "/raw/audio/english/l1/a3/vera-magnet.mp3", :size 2, :type "audio" :alias "vera magnet" :target "vera"}
                           {:url "/raw/audio/english/l1/a3/rock.mp3", :size 2, :type "audio" :alias "rock" :target "rock"}
                           {:url "/raw/audio/english/l1/a3/rock-squirrel.mp3", :size 2, :type "audio" :alias "rock squirrel" :target "rock"}
                           {:url "/raw/audio/english/l1/a3/rock-elephant.mp3", :size 2, :type "audio" :alias "rock elephant" :target "rock"}
                           {:url "/raw/audio/english/l1/a3/rock-magnet.mp3", :size 2, :type "audio" :alias "rock magnet" :target "rock"}],
           :objects       {:background   {:type "background", :src "/raw/img/park/swings/background.jpg"},
                           :vera         {:type  "animation" :x 251 :y 990 :name "vera" :anim "idle" :speed 0.3
                                          :width 1800 :height 2558 :scale {:x 0.2 :y 0.2} :start true}

                           :mari         {:type    "animation" :scene-name "mari" :name "mari" :anim "idle"
                                          :start   true :speed 0.35 :transition "mari"
                                          :x       1535 :y 715 :width 473 :height 511
                                          :scale-y 0.5 :scale-x 0.5}

                           :rock         {:type    "animation" :scene-name "rock" :name "rock" :anim "idle"
                                          :start   true :speed 0.35 :skin "female"
                                          :x       1168 :y 748 :width 591 :height 681
                                          :scale-y 0.6 :scale-x 0.6}

                           :swings       {:type   "group" :x 589 :y 160 :children ["swings-image" "box-ph"] :transition "swings"
                                          :origin {:type "center-center"}}
                           :swings-image {:type "image" :width 248 :height 681
                                          :src  "/raw/img/park/swings/swings.png" :origin {:type "center-top"}},

                           :tree-image   {:type "image" :width 592 :height 196 :x 656 :y 0
                                          :src  "/raw/img/park/swings/tree.png" :origin {:type "center-top"}},

                           :box1         {:type       "transparent" :x 350 :y 300 :width 771 :height 1033 :origin {:type "center-center"}
                                          :scale      {:x 0.3 :y 0.3} :anim-offset {:x 0 :y -300}
                                          :scene-name "box1" :draggable {:var-name "drag-box-1"} :transition "box1"
                                          :states     {:default          {:type "transparent" :x 350 :y 300}
                                                       :come             {:type     "animation" :name "boxes" :anim "come" :x 500 :y 550
                                                                          :speed    0.3 :loop false :start true
                                                                          :from-var [{:var-name "item-1" :action-property "skin" :var-property "skin"}]}
                                                       :initial-position {:x 600 :y 400}}
                                          :actions    {:drag-end {:type "action" :id "drag-box1" :on "drag-end"}}}

                           :box2         {:type       "transparent" :x 850 :y 300 :width 771 :height 1033 :origin {:type "center-center"}
                                          :scale      {:x 0.3 :y 0.3} :anim-offset {:x 0 :y -300}
                                          :scene-name "box2" :draggable {:var-name "drag-box-2"} :transition "box2"
                                          :states     {:default          {:type "transparent" :x 850 :y 300}
                                                       :come             {:type     "animation" :name "boxes" :anim "come" :x 1000 :y 550
                                                                          :from-var [{:var-name "item-2" :action-property "skin" :var-property "skin"}]
                                                                          :speed    0.3 :loop false :start true}
                                                       :initial-position {:x 1000 :y 400}}
                                          :actions    {:drag-end {:type "action" :id "drag-box2" :on "drag-end"}}}

                           :box3         {:type       "transparent" :x 1350 :y 300 :width 771 :height 1033 :origin {:type "center-center"}
                                          :scale      {:x 0.3 :y 0.3} :anim-offset {:x 0 :y -300}
                                          :scene-name "box3" :draggable {:var-name "drag-box-3"} :transition "box3"
                                          :states     {:default          {:type "transparent" :x 1350 :y 300}
                                                       :come             {:type     "animation" :name "boxes" :anim "come" :x 1500 :y 550
                                                                          :from-var [{:var-name "item-3" :action-property "skin" :var-property "skin"}]
                                                                          :speed    0.3 :loop false :start true}
                                                       :initial-position {:x 1400 :y 400}}
                                          :actions    {:drag-end {:type "action" :id "drag-box3" :on "drag-end"}}}

                           :box-ph       {:type       "transparent" :width 771 :height 1033 :x 0 :y 550 :origin {:type "center-center"}
                                          :scale      {:x 0.3 :y 0.3} :anim-offset {:x 0 :y -300}
                                          :scene-name "box-ph" :transition "box-ph"
                                          :states     {:default {:type "transparent" :x 0 :y 550}
                                                       :visible {:type  "animation" :name "boxes" :anim "idle2" :x 177 :y 785
                                                                 :speed 0.3 :loop true :start false}}}},
           :scene-objects [["background"] ["swings"] ["tree-image"] ["vera" "mari" "rock"] ["box1" "box2" "box3"]],
           :actions       {:welcome-audio              {:type                          "sequence"
                                                        :data                          ["vera-welcome-audio-1"
                                                                                        "mari-welcome-audio-2"
                                                                                        "vera-welcome-audio-3"
                                                                                        "mari-welcome-audio-4"
                                                                                        "rock-welcome-audio-5"
                                                                                        "mari-welcome-audio-6"
                                                                                        "rock-welcome-audio-7"
                                                                                        "vera-welcome-audio-8"
                                                                                        "rock-welcome-audio-9"
                                                                                        "mari-welcome-audio-10"]
                                                        :phrase                        :welcome
                                                        :phrase-description            "Diálogo de bienvenida entre Vera, Mari y Rock"
                                                        :phrase-description-translated "Welcome dialog between Vera, Mari and Rock"}
                           :vera-welcome-audio-1       {:type                   "animation-sequence",
                                                        :target                 "vera",
                                                        :track                  1,
                                                        :data                   [{:start 0.614, :end 1.534, :duration 0.92, :anim "talk"}
                                                                                 {:start 1.921, :end 3.801, :duration 1.88, :anim "talk"}
                                                                                 {:start 4.494, :end 5.801, :duration 1.307, :anim "talk"}],
                                                        :audio                  "/raw/audio/english/l1/a3/vera.mp3",
                                                        :offset                 0.48,
                                                        :start                  0.48,
                                                        :duration               5.668
                                                        :phrase-text            "Hola Mari! Vamos a jugar en los columpios? A mi me gustan los columpios."
                                                        :phrase-text-translated "Hello Mari! Are we going to play on the swings now? I like the swings."}
                           :mari-welcome-audio-2       {:type                   "animation-sequence",
                                                        :target                 "mari",
                                                        :track                  1,
                                                        :data                   [{:start 0.72, :end 3.226, :duration 2.506, :anim "talk"}
                                                                                 {:start 3.826, :end 4.666, :duration 0.84, :anim "talk"}
                                                                                 {:start 5.24, :end 7.2, :duration 1.96, :anim "talk"}
                                                                                 {:start 7.56, :end 9.279, :duration 1.719, :anim "talk"}
                                                                                 {:start 9.773, :end 11.906, :duration 2.133, :anim "talk"}],
                                                        :audio                  "/raw/audio/english/l1/a3/mari.m4a",
                                                        :offset                 0.587,
                                                        :start                  0.587,
                                                        :duration               11.559
                                                        :phrase-text            " Si! Vamos a jugar el los columpios! Nuestros amigos quieren ir a jugar en los columpios! Vamos a darles un turno a cada uno."
                                                        :phrase-text-translated "Yes! We are going to play on the swings! Our friends [ardilla, oso and imán] want to go on the swings. Let’s give each of them a turn."}
                           :vera-welcome-audio-3       {:type                   "animation-sequence",
                                                        :target                 "vera",
                                                        :track                  1,
                                                        :data                   [{:start 7.147, :end 7.561, :duration 0.414, :anim "talk"}
                                                                                 {:start 8.054, :end 10.108, :duration 2.054, :anim "talk"}],
                                                        :audio                  "/raw/audio/english/l1/a3/vera.mp3",
                                                        :offset                 6.921,
                                                        :start                  6.921,
                                                        :duration               3.4
                                                        :phrase-text            "Ok. Voy a darles turno a cada uno."
                                                        :phrase-text-translated "Ok. I’m going to give everyone a turn."}
                           :mari-welcome-audio-4       {:type                   "animation-sequence",
                                                        :target                 "mari",
                                                        :track                  1,
                                                        :data                   [{:start 14.186, :end 14.946, :duration 0.76, :anim "talk"}],
                                                        :audio                  "/raw/audio/english/l1/a3/mari.m4a",
                                                        :offset                 14.026,
                                                        :start                  14.026,
                                                        :duration               1.04
                                                        :phrase-text            "Muy bien! Buen trabajo!"
                                                        :phrase-text-translated "Good job!"}
                           :rock-welcome-audio-5       {:type                   "animation-sequence",
                                                        :target                 "rock",
                                                        :track                  1,
                                                        :data                   [{:start 0.534, :end 2.36, :duration 1.826, :anim "talk"}],
                                                        :audio                  "/raw/audio/english/l1/a3/rock.mp3",
                                                        :offset                 0.306,
                                                        :start                  0.306,
                                                        :duration               2.307
                                                        :phrase-text            "Que amable!"
                                                        :phrase-text-translated "That’s very kind of you!"}
                           :mari-welcome-audio-6       {:type                   "animation-sequence",
                                                        :target                 "mari",
                                                        :track                  1,
                                                        :data                   [{:start 16.986, :end 18.345, :duration 1.359, :anim "talk"}
                                                                                 {:start 18.865, :end 20.212, :duration 1.347, :anim "talk"}],
                                                        :audio                  "/raw/audio/english/l1/a3/mari.m4a",
                                                        :offset                 16.852,
                                                        :start                  16.852,
                                                        :duration               3.587
                                                        :phrase-text            "Oh, hola Senora Piedra! Es un placer verla!"
                                                        :phrase-text-translated "Oh, hello Senora Piedra! It’s a pleasure to see you."}
                           :rock-welcome-audio-7       {:type                   "animation-sequence",
                                                        :target                 "rock",
                                                        :track                  1,
                                                        :data                   [{:start 3.719, :end 4.559, :duration 0.84, :anim "talk"}
                                                                                 {:start 5.159, :end 6.986, :duration 1.827, :anim "talk"}],
                                                        :audio                  "/raw/audio/english/l1/a3/rock.mp3",
                                                        :offset                 3.547,
                                                        :start                  3.547,
                                                        :duration               3.747
                                                        :phrase-text            "Hola Mari. Igualmente! Es un placer verte!"
                                                        :phrase-text-translated "Hello Mari. It’s a pleasure to see you too."}
                           :vera-welcome-audio-8       {:type                   "animation-sequence",
                                                        :target                 "vera",
                                                        :track                  1,
                                                        :data                   [{:start 10.944, :end 11.837, :duration 0.893, :anim "talk"}
                                                                                 {:start 12.423, :end 13.21, :duration 0.787, :anim "talk"}],
                                                        :audio                  "/raw/audio/english/l1/a3/vera.mp3",
                                                        :offset                 10.69,
                                                        :start                  10.69,
                                                        :duration               2.786
                                                        :phrase-text            "Hola Senora Piedra. Como esta?"
                                                        :phrase-text-translated "Hola Senor Piedra. How are you?"}
                           :rock-welcome-audio-9       {:type                   "animation-sequence",
                                                        :target                 "rock",
                                                        :track                  1,
                                                        :data                   [{:start 8.199, :end 9.225, :duration 1.026, :anim "talk"}
                                                                                 {:start 9.959, :end 10.958, :duration 0.999, :anim "talk"}
                                                                                 {:start 11.465, :end 12.025, :duration 0.56, :anim "talk"}],
                                                        :audio                  "/raw/audio/english/l1/a3/rock.mp3",
                                                        :offset                 8.093,
                                                        :start                  8.093,
                                                        :duration               4.241
                                                        :phrase-text            "Hola mi amiga. Estoy muy bien, gracias!"
                                                        :phrase-text-translated "Hello my friend. I’m very well, thank you."}
                           :mari-welcome-audio-10      {:type                   "animation-sequence",
                                                        :target                 "mari",
                                                        :track                  1,
                                                        :data                   [{:start 23.398, :end 26.145, :duration 2.747, :anim "talk"}],
                                                        :audio                  "/raw/audio/english/l1/a3/mari.m4a",
                                                        :offset                 23.278,
                                                        :start                  23.278,
                                                        :duration               3.134
                                                        :phrase-text            "Ok pequeno genio! Vamos a comenzar!"
                                                        :phrase-text-translated "Ok little genius, let’s begin!"}
                           :mari-move-to-start         {:type                          "parallel"
                                                        :data                          [{:type "sequence-data"
                                                                                         :data [{:type "animation" :target "mari" :id "wand_hit" :track 2}
                                                                                                {:type "add-animation" :target "mari" :id "wand_idle" :track 2 :loop true}]}
                                                                                        {:type                   "animation-sequence",
                                                                                         :target                 "mari",
                                                                                         :track                  1,
                                                                                         :offset                 27.812,
                                                                                         :audio                  "/raw/audio/english/l1/a3/mari.m4a",
                                                                                         :start                  27.812,
                                                                                         :duration               2.426,
                                                                                         :data                   [{:start 27.865, :end 30.118, :duration 2.253, :anim "talk"}]
                                                                                         :phrase-text            "Mueve la foto sobre el columpio!"
                                                                                         :phrase-text-translated "Move the picture onto the swing."}]
                                                        :phrase                        :move-picture
                                                        :phrase-description            "Mueve la imagen para comenzar"
                                                        :phrase-description-translated "Move the picture to start"}

                           :show-boxes                 {:type "parallel"
                                                        :data [{:type "state" :target "box1" :id "come"}
                                                               {:type "state" :target "box2" :id "come"}
                                                               {:type "state" :target "box3" :id "come"}]}

                           :switch-box-animations-idle {:type "parallel"
                                                        :data [{:type     "set-skin" :target "box1"
                                                                :from-var [{:var-name "item-1" :action-property "skin" :var-property "skin"}]}
                                                               {:type     "set-skin" :target "box2"
                                                                :from-var [{:var-name "item-2" :action-property "skin" :var-property "skin"}]}
                                                               {:type     "set-skin" :target "box3"
                                                                :from-var [{:var-name "item-3" :action-property "skin" :var-property "skin"}]}
                                                               {:type "add-animation" :target "box1" :id "idle_fly1" :loop true}
                                                               {:type "add-animation" :target "box2" :id "idle_fly2" :loop true}
                                                               {:type "add-animation" :target "box3" :id "idle_fly3" :loop true}]}

                           :wait-for-box-animations    {:type "empty" :duration 500}

                           :set-current-box1           {:type "set-variable" :var-name "box1" :var-value true}
                           :set-current-box2           {:type "set-variable" :var-name "box2" :var-value true}
                           :set-current-box3           {:type "set-variable" :var-name "box3" :var-value true}

                           :check-box1                 {:type     "test-var-scalar"
                                                        :var-name "box1"
                                                        :value    true
                                                        :success  "box-1-start"
                                                        :fail     "box-1-revert"}

                           :check-box2                 {:type     "test-var-scalar"
                                                        :var-name "box2"
                                                        :value    true
                                                        :success  "box-2-start"
                                                        :fail     "box-2-revert"}

                           :check-box3                 {:type     "test-var-scalar"
                                                        :var-name "box3"
                                                        :value    true
                                                        :success  "box-3-start"
                                                        :fail     "box-3-revert"}

                           :drag-box1                  {:type         "test-transitions-collide"
                                                        :transition-1 "box1"
                                                        :transition-2 "box-ph"
                                                        :success      "check-box1"
                                                        :fail         "box-1-revert"}

                           :drag-box2                  {:type         "test-transitions-collide"
                                                        :transition-1 "box2"
                                                        :transition-2 "box-ph"
                                                        :success      "check-box2"
                                                        :fail         "box-2-revert"}

                           :drag-box3                  {:type         "test-transitions-collide"
                                                        :transition-1 "box3"
                                                        :transition-2 "box-ph"
                                                        :success      "check-box3"
                                                        :fail         "box-3-revert"}

                           :box-1-revert               {:type "transition" :transition-id "box1" :to {:x 500 :y 550 :duration 0.5}}

                           :box-1-start                {:type       "sequence"
                                                        :data       ["show-box-1-ph"
                                                                     "start-swings"
                                                                     "empty-before-dialog"
                                                                     "dialog-var"
                                                                     "stop-swings"
                                                                     "hide-box-1-ph"
                                                                     "mari-box-2"
                                                                     "try-another"
                                                                     "set-current-box2"]
                                                        :unique-tag "box"}

                           :show-box-1-ph              {:type "sequence"
                                                        :data ["show-box-1-ph-1"
                                                               "show-box-1-ph-2"
                                                               "show-box-1-ph-3"
                                                               "show-box-1-ph-4"
                                                               "show-box-1-ph-5"]}
                           :show-box-1-ph-1            {:type "state" :target "box1" :id "default"}
                           :show-box-1-ph-2            {:type "state" :target "box-ph" :id "visible"}
                           :show-box-1-ph-3            {:type "empty" :duration 500}
                           :show-box-1-ph-4            {:type     "set-skin" :target "box-ph"
                                                        :from-var [{:var-name "item-1" :action-property "skin" :var-property "skin"}]}
                           :show-box-1-ph-5            {:type "copy-variable" :var-name "current-word" :from "item-1"}

                           :hide-box-1-ph              {:type "sequence"
                                                        :data ["hide-box-1-ph-1"
                                                               "hide-box-1-ph-2"
                                                               "hide-box-1-ph-3"
                                                               "hide-box-1-ph-4"
                                                               "hide-box-1-ph-5"]}
                           :hide-box-1-ph-1            {:type "state" :target "box-ph" :id "default"}
                           :hide-box-1-ph-2            {:type "state" :target "box1" :id "come"}
                           :hide-box-1-ph-3            {:type "empty" :duration 500}
                           :hide-box-1-ph-4            {:type     "set-skin" :target "box1"
                                                        :from-var [{:var-name "item-1" :action-property "skin" :var-property "skin"}]}
                           :hide-box-1-ph-5            {:type "add-animation" :target "box1" :id "idle_fly1" :loop true}


                           :box-2-revert               {:type "transition" :transition-id "box2" :to {:x 1000 :y 550 :duration 0.5}}

                           :box-2-start                {:type       "sequence"
                                                        :data       ["show-box-2-ph"
                                                                     "start-swings"
                                                                     "empty-before-dialog"
                                                                     "dialog-var"
                                                                     "stop-swings"
                                                                     "hide-box-2-ph"
                                                                     "mari-box-3"
                                                                     "try-another"
                                                                     "set-current-box3"]
                                                        :unique-tag "box"}

                           :show-box-2-ph              {:type "sequence"
                                                        :data ["show-box-2-ph-1"
                                                               "show-box-2-ph-2"
                                                               "show-box-2-ph-3"
                                                               "show-box-2-ph-4"
                                                               "show-box-2-ph-5"]}

                           :show-box-2-ph-1            {:type "state" :target "box2" :id "default"}
                           :show-box-2-ph-2            {:type "state" :target "box-ph" :id "visible"}
                           :show-box-2-ph-3            {:type "empty" :duration 500}
                           :show-box-2-ph-4            {:type     "set-skin" :target "box-ph"
                                                        :from-var [{:var-name "item-2" :action-property "skin" :var-property "skin"}]}
                           :show-box-2-ph-5            {:type "copy-variable" :var-name "current-word" :from "item-2"}

                           :hide-box-2-ph              {:type "sequence"
                                                        :data ["hide-box-2-ph-1"
                                                               "hide-box-2-ph-2"
                                                               "hide-box-2-ph-3"
                                                               "hide-box-2-ph-4"
                                                               "hide-box-2-ph-5"]}
                           :hide-box-2-ph-1            {:type "state" :target "box-ph" :id "default"}
                           :hide-box-2-ph-2            {:type "state" :target "box2" :id "come"}
                           :hide-box-2-ph-3            {:type "empty" :duration 500}
                           :hide-box-2-ph-4            {:type     "set-skin" :target "box2"
                                                        :from-var [{:var-name "item-2" :action-property "skin" :var-property "skin"}]}
                           :hide-box-2-ph-5            {:type "add-animation" :target "box2" :id "idle_fly2" :loop true}

                           :box-3-revert               {:type "transition" :transition-id "box3" :to {:x 1500 :y 550 :duration 0.5}}

                           :box-3-start                {:type       "sequence"
                                                        :data       ["show-box-3-ph"
                                                                     "start-swings"
                                                                     "empty-before-dialog"
                                                                     "dialog-var"
                                                                     "stop-swings"
                                                                     "hide-box-3-ph"
                                                                     "finish-activity"
                                                                     "mari-finish"]
                                                        :unique-tag "box"}

                           :show-box-3-ph              {:type "sequence"
                                                        :data ["show-box-3-ph-1"
                                                               "show-box-3-ph-2"
                                                               "show-box-3-ph-3"
                                                               "show-box-3-ph-4"
                                                               "show-box-3-ph-5"]}

                           :show-box-3-ph-1            {:type "state" :target "box3" :id "default"}
                           :show-box-3-ph-2            {:type "state" :target "box-ph" :id "visible"}
                           :show-box-3-ph-3            {:type "empty" :duration 500}
                           :show-box-3-ph-4            {:type     "set-skin" :target "box-ph"
                                                        :from-var [{:var-name "item-3" :action-property "skin" :var-property "skin"}]}
                           :show-box-3-ph-5            {:type "copy-variable" :var-name "current-word" :from "item-3"}

                           :hide-box-3-ph              {:type "sequence"
                                                        :data ["hide-box-3-ph-1"
                                                               "hide-box-3-ph-2"
                                                               "hide-box-3-ph-3"
                                                               "hide-box-3-ph-4"
                                                               "hide-box-3-ph-5"]}

                           :hide-box-3-ph-1            {:type "state" :target "box-ph" :id "default"}
                           :hide-box-3-ph-2            {:type "state" :target "box3" :id "come"}
                           :hide-box-3-ph-3            {:type "empty" :duration 500}
                           :hide-box-3-ph-4            {:type     "set-skin" :target "box3"
                                                        :from-var [{:var-name "item-3" :action-property "skin" :var-property "skin"}]}
                           :hide-box-3-ph-5            {:type "add-animation" :target "box3" :id "idle_fly3" :loop true}

                           :dialog-var                 {:type                          "action" :from-var [{:var-name "current-word" :var-property "swings-dialog-action"}]
                                                        :phrase                        :dialog
                                                        :phrase-description            "Historia conceptual"
                                                        :phrase-description-translated "Concept story"}

                           :stop-swings                {:type "sequence"
                                                        :data ["stop-swings-1"
                                                               "stop-swings-2"]}
                           :stop-swings-1              {:type "remove-flows" :flow-tag "swings"}
                           :stop-swings-2              {:type "transition" :transition-id "swings" :to {:rotation 0 :duration 0.5 :loop false}}

                           :start-swings               {:type "sequence"
                                                        :tags ["swings"]
                                                        :data ["prepare-swing"
                                                               "swing"]}

                           :swing                      {:type               "sequence"
                                                        :tags               ["swings"]
                                                        :data               ["swing-right"
                                                                             "swing-left"
                                                                             "swing"]
                                                        :return-immediately true}

                           :prepare-swing              {:type "transition" :transition-id "swings" :to {:rotation -15 :duration 1 :loop false}}
                           :swing-right                {:type "transition" :transition-id "swings" :to {:rotation 15 :duration 2 :loop false}}
                           :swing-left                 {:type "transition" :transition-id "swings" :to {:rotation -15 :duration 2 :loop false}}

                           :empty-before-dialog        {:type "empty" :duration 3000}

                           :try-another                {:type                          "animation-sequence",
                                                        :target                        "mari",
                                                        :track                         1,
                                                        :offset                        32.105,
                                                        :audio                         "/raw/audio/english/l1/a3/mari.m4a",
                                                        :start                         32.105,
                                                        :duration                      7.012,
                                                        :data                          [{:start 32.278, :end 33.678, :duration 1.4, :anim "talk"}
                                                                                        {:start 34.104, :end 35.811, :duration 1.707, :anim "talk"}
                                                                                        {:start 36.411, :end 38.691, :duration 2.28, :anim "talk"}]
                                                        :phrase                        :try-another
                                                        :phrase-description            "Prueba otra foto"
                                                        :phrase-description-translated "Try another picture"
                                                        :phrase-text                   "Buen trabajo pequeno genio! Vamos a intentarlo de nuevo! Mueve la foto sobre los columpios. "
                                                        :phrase-text-translated        "Good job little genius! Let’s try another one. Move this picture to the swings."}

                           :renew-words                {:type        "lesson-var-provider"
                                                        :provider-id "words-set"
                                                        :variables   ["item-1" "item-2" "item-3"]
                                                        :from        "concepts"}

                           :mari-box-1                 {:type "transition" :transition-id "mari" :to {:x 671 :y 350 :duration 2 :loop false}}
                           :mari-box-2                 {:type "transition" :transition-id "mari" :to {:x 1181 :y 350 :duration 2 :loop false}}
                           :mari-box-3                 {:type "transition" :transition-id "mari" :to {:x 1658 :y 350 :duration 2 :loop false}}

                           :mari-init-wand             {:type "add-animation" :target "mari" :id "wand_idle" :track 2 :loop true}

                           :clear-instruction          {:type "remove-flows" :flow-tag "instruction"}
                           :start-scene                {:type "sequence"
                                                        :data [
                                                               "start-activity"
                                                               "clear-instruction"
                                                               "renew-words"
                                                               "show-boxes"
                                                               "wait-for-box-animations"
                                                               "switch-box-animations-idle"
                                                               "welcome-audio"
                                                               "mari-init-wand"
                                                               "mari-box-1"
                                                               "mari-move-to-start"
                                                               "set-current-box1"]}

                           :mari-finish                {:type                          "sequence-data",
                                                        :data                          [{:type          "transition",
                                                                                         :transition-id "mari",
                                                                                         :to            {:x 244, :y 300, :duration 1.3}}
                                                                                        {:type                   "animation-sequence",
                                                                                         :target                 "mari",
                                                                                         :track                  1,
                                                                                         :offset                 49.103,
                                                                                         :audio                  "/raw/audio/english/l1/a3/mari.m4a",
                                                                                         :data
                                                                                                                 [{:start 49.357, :end 52.717, :duration 3.36, :anim "talk"}
                                                                                                                  {:start 52.983, :end 54.49, :duration 1.507, :anim "talk"}
                                                                                                                  {:start 55.13, :end 57.09, :duration 1.96, :anim "talk"}
                                                                                                                  {:start 57.33, :end 59.036, :duration 1.706, :anim "talk"}
                                                                                                                  {:start 59.676, :end 61.223, :duration 1.547, :anim "talk"}],
                                                                                         :start                  49.103,
                                                                                         :duration               12.36,
                                                                                         :phrase-text            "Parece que cada foto tuvo un turno en el columpio. Buen trabajo pequeno genio! Puedes jugar este juego de nuevo o hacer clic sobre esta flecha para empezar tu proximo juego."
                                                                                         :phrase-text-translated "It looks like every picture got a turn on the swing. Good job little genius! You can play this game again, or, hit this arrow to start your next game."}]
                                                        :phrase                        :finish
                                                        :phrase-description            "Juega de nuevo o pasa a la siguiente actividad"
                                                        :phrase-description-translated "Play again or go to the next activity"}

                           :start-activity             {:type "start-activity" :id "swings"}
                           :finish-activity            {:type "finish-activity" :id "swings"}
                           :stop-activity              {:type "stop-activity" :id "swings"}}
           :triggers      {:start {:on "start" :action "start-scene"}
                           :back  {:on "back" :action "stop-activity"}}
           :metadata      {:autostart true
                           :prev      "park"}})
