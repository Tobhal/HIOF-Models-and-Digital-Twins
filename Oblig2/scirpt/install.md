# Install instructins

## Install packages

Install the following packages using `apt-get`:

```shell
$ sudo apt-get install python3-numpy
$ sudo apt-get install libblas-dev
$ sudo apt-get install liblapack-dev
$ sudo apt-get install python3-dev 
$ sudo apt-get install libatlas-base-dev
$ sudo apt-get install gfortran
$ sudo apt-get install python3-setuptools
$ sudo apt-get install python3-scipy
$ sudo apt-get update
$ sudo apt-get install python3-h5py
```
If a separate venv is wanted this is also required:

```shell
$ sudo apt-get install python3-venv
```

To create the venv use the following command:

```shell
$ python -m venv /path/to/new/virtual/environment
```

## PIP install

Using the venv, or not, install the following pip packages:
```shell
$ pip install --upgrade scipy
$ pip install --upgrade cython
$ pip install tensorflow
$ pip install keras 
```

## Test install
Test the install