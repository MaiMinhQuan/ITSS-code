//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.service;

import com.example.ITSSBE.entity.Package;
import java.util.List;

public interface IPackageService {
    Package addPackage(Package pa);

    List<Package> getAllPackages();

    Package getPackage(int id);

    Package changePackage(int id, Package pa);

    Package deletePackage(int id);
}

//package com.example.ITSSBE.service;
//
//import com.example.ITSSBE.entity.Package;
//
//import java.util.List;
//
//public interface IPackageService {
//    Package addPackage(Package pa);
//    List<Package> getAllPackages();
//    Package getPackage(int id);
//    Package changePackage(int id, Package pa);
//    Package deletePackage(int id);
//}
