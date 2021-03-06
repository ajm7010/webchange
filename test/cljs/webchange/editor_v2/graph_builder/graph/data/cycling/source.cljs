(ns webchange.editor-v2.graph-builder.graph.data.cycling.source)

(def data {:assets        [{:url "/raw/img/stadium/cycling/cycle_race_bg_01.jpg", :size 10, :type "image"}
                           {:url "/raw/img/stadium/cycling/cycle_race_bg_02.jpg", :size 10, :type "image"}
                           {:url "/raw/img/stadium/cycling/cycle_race_bg_03.jpg", :size 10, :type "image"}

                           {:url "/raw/audio/l1/a5/Mari_Coaching_statements.m4a", :size 2, :type "audio" :alias "statements" :target "mari"}
                           {:url "/raw/audio/l1/a8/Mari_L1_A8.m4a", :size 2, :type "audio" :alias "mari" :target "mari"}
                           {:url "/raw/audio/l1/a8/GameVoice.m4a", :size 2, :type "audio" :alias "game voice" :target "game-voice"}

                           {:url "/raw/audio/l1/a2/L1_A2_GameVoice_Object_1_List.m4a", :size 5, :type "audio" :alias "game voice 1" :target "game-voice"}
                           {:url "/raw/audio/l1/a2/L1_A2_GameVoice_Object_2_List.m4a", :size 5, :type "audio" :alias "game voice 2" :target "game-voice"}
                           {:url "/raw/audio/l1/a2/L1_A2_GameVoice_Object_3_List.m4a", :size 5, :type "audio" :alias "game voice 3" :target "game-voice"}

                           {:url "/raw/audio/background/POL-daily-special-short.mp3", :size 5, :type "audio" :alias "background" :target "background"}],

           :objects       {:background {:type  "carousel" :x 0 :y 0 :width 1920 :height 1080
                                        :first "/raw/img/stadium/cycling/cycle_race_bg_01.jpg"
                                        :next  "/raw/img/stadium/cycling/cycle_race_bg_02.jpg"
                                        :last  "/raw/img/stadium/cycling/cycle_race_bg_03.jpg"},

                           :vera       {:type       "animation" :x 500 :y 721 :scene-name "vera" :name "vera-90" :anim "bike_ride"
                                        :speed      0.3 :skin "default"
                                        :transition "vera"
                                        :width      727 :height 1091 :scale {:x 0.4 :y 0.4} :start true :meshes true}

                           :mari       {:type    "animation" :scene-name "mari" :name "mari" :anim "idle"
                                        :start   true :speed 0.35 :transition "mari"
                                        :x       1265 :y 311 :width 473 :height 511 :anim-offset {:x 0 :y -150}
                                        :scale-y 0.5 :scale-x 0.5}

                           :box1       {:type       "animation" :x 2000 :y 683 :width 671 :height 633 :anim-offset {:x 0 :y -300}
                                        :name       "boxes" :anim "idle2" :scale {:x -0.25 :y 0.25} :speed 0.3 :loop true :start true
                                        :scene-name "box1" :transition "box1" :skin "qwestion"
                                        :states     {:init  {:type "transparent"}
                                                     :reset {:type "animation"}}
                                        :actions    {:click {:type "action" :id "pick-box-1" :on "click"}}}

                           :box2       {:type       "animation" :x 2200 :y 789 :width 671 :height 633 :anim-offset {:x 0 :y -300}
                                        :name       "boxes" :anim "idle2" :scale {:x -0.25 :y 0.25} :speed 0.3 :loop true :start true
                                        :scene-name "box2" :transition "box2" :skin "qwestion"
                                        :states     {:init  {:type "transparent"}
                                                     :reset {:type "animation"}}
                                        :actions    {:click {:type "action" :id "pick-box-2" :on "click"}}}

                           :box3       {:type       "animation" :x 2400 :y 932 :width 671 :height 633 :anim-offset {:x 0 :y -300}
                                        :name       "boxes" :anim "idle2" :scale {:x -0.25 :y 0.25} :speed 0.3 :loop true :start true
                                        :scene-name "box3" :transition "box3" :skin "qwestion"
                                        :states     {:init  {:type "transparent"}
                                                     :reset {:type "animation"}}
                                        :actions    {:click {:type "action" :id "pick-box-3" :on "click"}}}},

           :scene-objects [["background"] ["box1" "box2" "box3"] ["vera" "mari"]],

           :actions       {:start-scene             {:type "sequence"
                                                     :data ["start-activity"
                                                            "clear-instruction"
                                                            "init-slots"
                                                            "init-vera-position"
                                                            "init-audio-correct"
                                                            "init-audio-try-again"
                                                            "renew-words"
                                                            "mari-welcome-audio-1"
                                                            "renew-current-concept"
                                                            "voice-high-var"]}

                           :mari-welcome-audio-1    {:type               "animation-sequence",
                                                     :target             "mari",
                                                     :track              1,
                                                     :offset             0.511,
                                                     :audio              "/raw/audio/l1/a8/Mari_L1_A8.m4a",
                                                     :start              0.511,
                                                     :duration           10.782,
                                                     :data               [{:start 1.012, :end 2.225, :duration 1.213, :anim "talk"}
                                                                          {:start 2.881, :end 6.103, :duration 3.222, :anim "talk"}
                                                                          {:start 6.853, :end 11.244, :duration 4.391, :anim "talk"}]
                                                     :phrase             :welcome
                                                     :phrase-description "Welcome speech"
                                                     :phrase-text        "Buenas dias! It’s a great day to ride a bicycle! Listen to the words and touch the correct picture."}

                           :mari-audio-correct-1    {:type        "animation-sequence",
                                                     :target      "mari",
                                                     :track       1,
                                                     :offset      0.858,
                                                     :audio       "/raw/audio/l1/a5/Mari_Coaching_statements.m4a",
                                                     :start       0.858,
                                                     :duration    1.837,
                                                     :data        [{:start 1.052, :end 2.505, :duration 1.453, :anim "talk"}],
                                                     :phrase-text "That’s correct!"}

                           :mari-audio-correct-2    {:type        "animation-sequence",
                                                     :target      "mari",
                                                     :track       1,
                                                     :offset      4.697,
                                                     :audio       "/raw/audio/l1/a5/Mari_Coaching_statements.m4a",
                                                     :start       4.697,
                                                     :duration    1.358,
                                                     :data        [{:start 4.867, :end 5.926, :duration 1.059, :anim "talk"}],
                                                     :phrase-text "Good job!"}

                           :mari-audio-correct-3    {:type        "animation-sequence",
                                                     :target      "mari",
                                                     :track       1,
                                                     :offset      7.949,
                                                     :audio       "/raw/audio/l1/a5/Mari_Coaching_statements.m4a",
                                                     :start       7.949,
                                                     :duration    1.345,
                                                     :data        [{:start 8.066, :end 9.098, :duration 1.032, :anim "talk"}],
                                                     :phrase-text "Well done!"}

                           :mari-audio-correct-4    {:type        "animation-sequence",
                                                     :target      "mari",
                                                     :track       1,
                                                     :offset      10.997,
                                                     :audio       "/raw/audio/l1/a5/Mari_Coaching_statements.m4a",
                                                     :start       10.997,
                                                     :duration    1.147,
                                                     :data        [{:start 11.119, :end 11.964, :duration 0.845, :anim "talk"}],
                                                     :phrase-text "You got it!"}

                           :mari-audio-correct-5    {:type        "animation-sequence",
                                                     :target      "mari",
                                                     :track       1,
                                                     :offset      14.463,
                                                     :audio       "/raw/audio/l1/a5/Mari_Coaching_statements.m4a",
                                                     :start       14.463,
                                                     :duration    2.333,
                                                     :data        [{:start 14.611, :end 15.11, :duration 0.499, :anim "talk"}
                                                                   {:start 15.529, :end 16.676, :duration 1.147, :anim "talk"}],
                                                     :phrase-text "Wow, excelent!"}

                           :mari-audio-try-again-1  {:type        "animation-sequence",
                                                     :target      "mari",
                                                     :track       1,
                                                     :offset      18.915,
                                                     :audio       "/raw/audio/l1/a5/Mari_Coaching_statements.m4a",
                                                     :start       18.915,
                                                     :duration    1.493,
                                                     :data        [{:start 18.983, :end 20.242, :duration 1.259, :anim "talk"}],
                                                     :phrase-text "Try again!"}

                           :mari-audio-try-again-2  {:type        "animation-sequence",
                                                     :target      "mari",
                                                     :track       1,
                                                     :offset      22.155,
                                                     :audio       "/raw/audio/l1/a5/Mari_Coaching_statements.m4a",
                                                     :start       22.155,
                                                     :duration    3.025,
                                                     :data        [{:start 23.743, :end 25.055, :duration 1.312, :anim "talk"}],
                                                     :phrase-text "Hmmmm. Try again."}

                           :init-audio-correct      {:type "parallel"
                                                     :data [{:type "set-variable" :var-name "audio-correct1" :var-value "mari-audio-correct-1"}
                                                            {:type "set-variable" :var-name "audio-correct2" :var-value "mari-audio-correct-2"}
                                                            {:type "set-variable" :var-name "audio-correct3" :var-value "mari-audio-correct-3"}
                                                            {:type "set-variable" :var-name "audio-correct4" :var-value "mari-audio-correct-4"}
                                                            {:type "set-variable" :var-name "audio-correct5" :var-value "mari-audio-correct-5"}]}

                           :init-audio-try-again    {:type "parallel"
                                                     :data [{:type "set-variable" :var-name "audio-try-again1" :var-value "mari-audio-try-again-1"}
                                                            {:type "set-variable" :var-name "audio-try-again2" :var-value "mari-audio-try-again-2"}]}

                           :init-slots              {:type "parallel"
                                                     :data [{:type "set-variable" :var-name "slot1" :var-value "box1"}
                                                            {:type "set-variable" :var-name "slot2" :var-value "box2"}
                                                            {:type "set-variable" :var-name "slot3" :var-value "box3"}]}

                           :clear-instruction       {:type "remove-flows" :flow-tag "instruction"}

                           :renew-words             {:type        "lesson-var-provider"
                                                     :provider-id "words-set"
                                                     :variables   ["item-1" "item-2" "item-3" "item-4" "item-5" "item-6" "item-7" "item-8" "item-9" "item-10"]
                                                     :shuffled    true
                                                     :limit       3
                                                     :repeat      4
                                                     :from        "concepts"}

                           :renew-current-concept   {:type "sequence"
                                                     :data ["set-boxes-init"
                                                            "wait-for-box-animations"
                                                            "move-boxes-right"
                                                            "set-boxes-reset"
                                                            "wait-for-box-animations"
                                                            "init-current-concept"
                                                            "set-words-vars"
                                                            "set-boxes-vars"
                                                            "init-current-target"
                                                            "set-boxes-skin"
                                                            "move-boxes-center"]}

                           :set-boxes-init          {:type "parallel"
                                                     :data [{:type "state" :target "box1" :id "init"}
                                                            {:type "state" :target "box2" :id "init"}
                                                            {:type "state" :target "box3" :id "init"}]}

                           :move-boxes-right        {:type "parallel"
                                                     :data [{:type "transition" :transition-id "box1" :to {:x 2000 :duration 0.1}}
                                                            {:type "transition" :transition-id "box2" :to {:x 2200 :duration 0.1}}
                                                            {:type "transition" :transition-id "box3" :to {:x 2400 :duration 0.1}}]}

                           :set-boxes-reset         {:type "parallel"
                                                     :data [{:type "state" :target "box1" :id "reset"}
                                                            {:type "state" :target "box2" :id "reset"}
                                                            {:type "state" :target "box3" :id "reset"}]}

                           :init-current-concept    {:type        "vars-var-provider"
                                                     :provider-id "current-concept"
                                                     :variables   ["current-concept"]
                                                     :from        ["item-1" "item-2" "item-3" "item-4" "item-5" "item-6" "item-7" "item-8" "item-9" "item-10"]
                                                     :shuffled    false
                                                     :on-end      "finish-activity"}

                           :set-words-vars          {:type "parallel"
                                                     :data [{:type     "set-variable" :var-name "word1"
                                                             :from-var [{:var-name "current-concept" :action-property "var-value" :var-property "word-1-skin"}]}
                                                            {:type     "set-variable" :var-name "word2"
                                                             :from-var [{:var-name "current-concept" :action-property "var-value" :var-property "word-2-skin"}]}
                                                            {:type     "set-variable" :var-name "word3"
                                                             :from-var [{:var-name "current-concept" :action-property "var-value" :var-property "word-3-skin"}]}
                                                            {:type     "set-variable" :var-name "word4"
                                                             :from-var [{:var-name "current-concept" :action-property "var-value" :var-property "word-4-skin"}]}]}

                           :set-boxes-vars          {:type      "vars-var-provider"
                                                     :variables ["box1" "box2" "box3"]
                                                     :from      ["word1" "word2" "word3" "word4"]
                                                     :shuffled  true}

                           :init-current-target     {:type "sequence-data"
                                                     :data [{:type      "vars-var-provider"
                                                             :variables ["current-target"]
                                                             :from      ["slot1" "slot2" "slot3"]
                                                             :shuffled  true}
                                                            {:type     "set-variable"
                                                             :from-var [{:var-name "current-concept" :action-property "var-value" :var-property "skin"}
                                                                        {:var-name "current-target" :action-property "var-name"}]}]}

                           :set-boxes-skin          {:type "parallel"
                                                     :data [{:type     "set-skin" :target "box1"
                                                             :from-var [{:var-name "box1" :action-property "skin"}]}
                                                            {:type     "set-skin" :target "box2"
                                                             :from-var [{:var-name "box2" :action-property "skin"}]}
                                                            {:type     "set-skin" :target "box3"
                                                             :from-var [{:var-name "box3" :action-property "skin"}]}]}

                           :move-boxes-center       {:type "parallel"
                                                     :data [{:type "transition" :transition-id "box1" :to {:x 1300 :duration 2}}
                                                            {:type "transition" :transition-id "box2" :to {:x 1500 :duration 2}}
                                                            {:type "transition" :transition-id "box3" :to {:x 1700 :duration 2}}]}

                           :init-vera-position      {:type "set-variable" :var-name "current-line" :var-value "box2"}

                           :stay-on-line            {:type "empty" :duration 100}

                           :wait-for-box-animations {:type "empty" :duration 100}

                           :go-to-box1-line         {:type "sequence-data"
                                                     :data [{:type "animation" :target "vera" :id "bike_turnup"}
                                                            {:type "add-animation" :target "vera" :id "bike_ride" :loop true}
                                                            {:type "set-variable" :var-name "current-line" :var-value "box1"}
                                                            {:type     "transition" :transition-id "vera"
                                                             :from-var [{:var-name "current-line-pos" :action-property "to"}]}]}

                           :pick-box-1              {:type "sequence-data"
                                                     :data [{:type "set-variable" :var-name "current-line-pos" :var-value {:y 621 :duration 0.5}}
                                                            {:type "set-variable" :var-name "current-line-jump" :var-value {:y 421 :duration 1}}
                                                            {:type "set-variable" :var-name "jump-wait" :var-value 500}
                                                            {:type     "test-value"
                                                             :value1   "box1"
                                                             :from-var [{:var-name "current-line" :action-property "value2"}]
                                                             :success  "stay-on-line"
                                                             :fail     "go-to-box1-line"}
                                                            {:type     "test-value"
                                                             :value1   "box1"
                                                             :from-var [{:var-name "current-target" :action-property "value2"}]
                                                             :success  "pick-correct"
                                                             :fail     "mari-says-wrong"}]}

                           :go-to-box2-line-up      {:type "sequence-data"
                                                     :data [{:type "animation" :target "vera" :id "bike_turnup"}
                                                            {:type "add-animation" :target "vera" :id "bike_ride" :loop true}
                                                            {:type "set-variable" :var-name "current-line" :var-value "box2"}
                                                            {:type     "transition" :transition-id "vera"
                                                             :from-var [{:var-name "current-line-pos" :action-property "to"}]}]}

                           :go-to-box2-line-down    {:type "sequence-data"
                                                     :data [{:type "animation" :target "vera" :id "bike_turndown"}
                                                            {:type "add-animation" :target "vera" :id "bike_ride" :loop true}
                                                            {:type "set-variable" :var-name "current-line" :var-value "box2"}
                                                            {:type     "transition" :transition-id "vera"
                                                             :from-var [{:var-name "current-line-pos" :action-property "to"}]}]}

                           :pick-box-2              {:type "sequence-data"
                                                     :data [{:type "set-variable" :var-name "current-line-pos" :var-value {:y 721 :duration 0.5}}
                                                            {:type "set-variable" :var-name "current-line-jump" :var-value {:y 521 :duration 1}}
                                                            {:type "set-variable" :var-name "jump-wait" :var-value 800}
                                                            {:type     "case"
                                                             :from-var [{:var-name "current-line" :action-property "value"}]
                                                             :options  {:box1 {:type "action" :id "go-to-box2-line-down"}
                                                                        :box2 {:type "action" :id "stay-on-line"}
                                                                        :box3 {:type "action" :id "go-to-box2-line-up"}}}
                                                            {:type     "test-value"
                                                             :value1   "box2"
                                                             :from-var [{:var-name "current-target" :action-property "value2"}]
                                                             :success  "pick-correct"
                                                             :fail     "mari-says-wrong"}]}

                           :go-to-box3-line         {:type "sequence-data"
                                                     :data [{:type "animation" :target "vera" :id "bike_turndown"}
                                                            {:type "add-animation" :target "vera" :id "bike_ride" :loop true}
                                                            {:type "set-variable" :var-name "current-line" :var-value "box3"}
                                                            {:type     "transition" :transition-id "vera"
                                                             :from-var [{:var-name "current-line-pos" :action-property "to"}]}]}

                           :pick-box-3              {:type "sequence-data"
                                                     :data [{:type "set-variable" :var-name "current-line-pos" :var-value {:y 821 :duration 0.5}}
                                                            {:type "set-variable" :var-name "current-line-jump" :var-value {:y 621 :duration 1}}
                                                            {:type "set-variable" :var-name "jump-wait" :var-value 1200}
                                                            {:type     "test-value"
                                                             :value1   "box3"
                                                             :from-var [{:var-name "current-line" :action-property "value2"}]
                                                             :success  "stay-on-line"
                                                             :fail     "go-to-box3-line"}
                                                            {:type     "test-value"
                                                             :value1   "box3"
                                                             :from-var [{:var-name "current-target" :action-property "value2"}]
                                                             :success  "pick-correct"
                                                             :fail     "mari-says-wrong"}]}

                           :mari-says-wrong         {:type               "sequence-data"
                                                     :data               [{:type      "vars-var-provider"
                                                                           :variables ["current-audio-try-again"]
                                                                           :from      ["audio-try-again1" "audio-try-again2"]
                                                                           :shuffled  true}
                                                                          {:type "action" :from-var [{:var-name        "current-audio-try-again" :action-property "id"
                                                                                                      :possible-values [:mari-audio-try-again-1
                                                                                                                        :mari-audio-try-again-2]}]}]
                                                     :phrase             :pick-wrong
                                                     :phrase-description "Wrong answer"}

                           :mari-says-correct       {:type               "sequence-data"
                                                     :data               [{:type      "vars-var-provider"
                                                                           :variables ["current-audio-correct"]
                                                                           :from      ["audio-correct1" "audio-correct2" "audio-correct3" "audio-correct4" "audio-correct5"]
                                                                           :shuffled  true}
                                                                          {:type "action" :from-var [{:var-name        "current-audio-correct" :action-property "id"
                                                                                                      :possible-values [:mari-audio-correct-1
                                                                                                                        :mari-audio-correct-2
                                                                                                                        :mari-audio-correct-3
                                                                                                                        :mari-audio-correct-4
                                                                                                                        :mari-audio-correct-5]}]}]
                                                     :phrase             :correct
                                                     :phrase-description "Correct answer"}

                           :pick-correct            {:type "sequence-data"
                                                     :data [{:type "parallel"
                                                             :data [{:type "action" :id "mari-says-correct"}
                                                                    {:type "transition" :transition-id "box1" :to {:x -700 :duration 4}}
                                                                    {:type "transition" :transition-id "box2" :to {:x -500 :duration 4}}
                                                                    {:type "transition" :transition-id "box3" :to {:x -300 :duration 4}}
                                                                    {:type "sequence-data"
                                                                     :data [{:type     "empty"
                                                                             :from-var [{:var-name "jump-wait" :action-property "duration"}]}
                                                                            {:type "animation" :target "vera" :id "bike_jump"}
                                                                            {:type     "transition" :transition-id "vera"
                                                                             :from-var [{:var-name "current-line-jump" :action-property "to"}]}
                                                                            {:type "add-animation" :target "vera" :id "bike_ride" :loop true}
                                                                            {:type     "transition" :transition-id "vera"
                                                                             :from-var [{:var-name "current-line-pos" :action-property "to"}]}]}]}
                                                            {:type "action" :id "renew-current-concept"}
                                                            {:type "action" :id "voice-high-var"}]}

                           :voice-high-var          {:type               "action" :from-var [{:var-name "current-concept" :var-property "game-voice-action"}]
                                                     :phrase             :concept-chant
                                                     :phrase-description "Concept chant"}

                           :start-activity          {:type "start-activity" :id "cycling"}
                           :stop-activity           {:type "stop-activity" :id "cycling"}
                           :finish-activity         {:type "sequence-data"
                                                     :data [{:type "finish-activity" :id "cycling"}
                                                            {:type "scene" :scene-id "stadium"}]}
                           :start-background-music  {:type "audio" :id "background" :loop true}},
           :audio         {:background "/raw/audio/background/POL-daily-special-short.mp3"}
           :triggers      {:start {:on "start" :action "start-scene"}
                           :stop  {:on "back" :action "stop-activity"}}
           :metadata      {:autostart true
                           :prev      "stadium"}})
