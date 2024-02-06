[![Automatic version updates](https://github.com/ZOSOpenTools/gnport/actions/workflows/bump.yml/badge.svg)](https://github.com/ZOSOpenTools/gnport/actions/workflows/bump.yml)

# gnport

A port of the Google Generate Ninja (gn) meta-build system to z/OS Open Tools project


## Developer Notes

In case of an error, use this workflow to ensure the file system is in 
pristine state.

```
$ zopen remove -p zoslib
$ zopen-clean --all -c -d -u -v
$ zopen clean -d
```

Afterwards, examine the file system for no stale binaries.

```
$ cd ${HOME}/zopen
$ find . -name "libzoslib*"
```

Note, a copy of zoslib will show up as `$HOME/zopen/usr/local/bin/CMakeFiles/libzoslib.dir`
but that is ok.  No need to remove in order to build gnport.



### Actual build of gnport

Once the the filesystem is pristine, do the actual build.

```
$ cd ${HOME}/zopen/dev/gnport
$ rm -rf gn
$ zopen build
```

A good build will have results in ~/zopen as shown:

(NOTE: the timestamps will vary over time.)

```
$ ~/zopen
$ find . -name "libzoslib*"
./usr/local/zopen/zoslib/zoslib-main.20240110_084622.zos/lib/libzoslib.x
./usr/local/zopen/zoslib/zoslib-main.20240110_084622.zos/lib/libzoslib.a
./usr/local/zopen/zoslib/zoslib-main.20240110_084622.zos/lib/libzoslib.so
./usr/local/zopen/zoslib/zoslib-main.20240110_084622.zos/lib/libzoslib-supp.a
./usr/local/zopen/zoslib/zoslib-main.20240110_084622.zos/bin/CMakeFiles/libzoslib.dir
./usr/local/bin/CMakeFiles/libzoslib.dir
./usr/local/lib/libzoslib.x
./usr/local/lib/libzoslib.a
./usr/local/lib/libzoslib.so
./usr/local/lib/libzoslib-supp.a
```
