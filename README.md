## README

STATUS: Pre-alpha, in design and prototyping phase.

#### About

`tape.clj-template`

Tape Framework app template.

#### Usage

You must be familiar with [clj-new](https://github.com/seancorfield/clj-new) and have it installed.

```bash
CLJ_CONFIG=./versions/ clj -Aversions \
  -Sdeps '{:deps {tape/clj-template {:local/root "./clj-template"}}}' \
  -X:new clj-new/create :template tape :name myname/myapp
```

#### License

Copyright © 2020 clyfe

Distributed under the MIT license.
