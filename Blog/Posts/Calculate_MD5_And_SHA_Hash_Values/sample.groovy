def value = 'IamASecret'

def md5 = value.md5()

// We can provide hash algorithm with digest method.
def md2 = value.digest('MD2')
def sha1 = value.digest('SHA-1')
def sha256 = value.digest('SHA-256')

assert md5 == 'a5f3147c32785421718513f38a20ca44'
assert md2 == '832cbe3966e186194b1203c00ef47488'
assert sha1 == '52ebfed118e0a411e9d9cbd60636fc9dea718928'
assert sha256 == '4f5e3d486d1fd6c822a81aa0b93d884a2a44daf2eb69ac779a91bc76de512cbe'
