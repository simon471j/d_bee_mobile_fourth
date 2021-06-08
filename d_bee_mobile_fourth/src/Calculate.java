import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Calculate {
    static List<TaxiInfo> taxiInfoList = new ArrayList<>();
    static List<District> districts = new ArrayList<>();

    public static void main(String[] args) {
        File taxiFile = new File("taxi_gps.txt");
        String allTaxiInfo = readFile(taxiFile);
//         获得每辆车的数据 存储到taxiInfoArray
        String[] taxiInfoArray = allTaxiInfo.split("\n");
//        把每辆车的信息存在POJO
        storeTaxiInfo(taxiInfoArray);

        File districtFile = new File("district.txt");
        String allDistrictInfo = readFile(districtFile);
//        获取每个区域的单挑数据
        String[] districtInfoArray = allDistrictInfo.split("\n");
//        将每个区域的数据存在POJO
        storeDistrictInfo(districtInfoArray);

//        输出每个区域的车的数量
        for (District district : districts) {
            String name = district.getName();
            double locationLng = district.getLocationLng();
            double locationLat = district.getLocationLat();
//              半径的平方
            double radiusSquared =  Math.pow(district.getRadius(), 2);
            int carCount = 0;
            for (TaxiInfo taxi : taxiInfoList) {
//                距离的平方
//                经过查阅一经度和一纬度都是大约是111KM
                double distanceSquared = (Math.pow((taxi.getGPSLat() - locationLat) * 111, 2) + Math.pow((taxi.getGPSLng() - locationLng) * 111, 2));
                if (radiusSquared > distanceSquared)
                    carCount++;
            }
            System.out.println("在" + name + "区域有" + carCount + "辆车");
        }
    }

    static String readFile(File file) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String content;
            while ((content = bufferedReader.readLine()) != null)
                result.append(content).append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    static void storeDistrictInfo(String[] districtInfoArray) {
        for (int i = 0; i < districtInfoArray.length; i++) {
            String[] singleDistrictInfo = districtInfoArray[i].split(",");
            District district = new District();
            district.setName(singleDistrictInfo[0]);
            district.setLocationLng(Double.parseDouble(singleDistrictInfo[1]));
            district.setLocationLat(Double.parseDouble(singleDistrictInfo[2]));
            district.setRadius(Float.parseFloat(singleDistrictInfo[3]));
            districts.add(district);
        }
    }


    static void storeTaxiInfo(String[] taxiInfoArray) {
        /*
         该字符串集合的前两项为干扰项：

         例如
         （车辆标识）154747,（触发事件）4,（运营状态）2,（gps时间）20121130001607,（gps维度 ）116.6999512,（gps经度）39.9006233,（gps方位）0,（gps方位）128,（gps状态）1
         所以信息检索从第三条开始
*/
        for (int i = 2; i < taxiInfoArray.length; i++) {
            String[] infoList = taxiInfoArray[i].split(",");
//        获取车辆的每个数据存储为对象
            TaxiInfo taxiInfo = new TaxiInfo();
            taxiInfo.setVehicleIdentification(Integer.parseInt(infoList[0]));
            taxiInfo.setTriggeredEvent(Integer.parseInt(infoList[1]));
            taxiInfo.setRunningStatus(Integer.parseInt(infoList[2]));
            taxiInfo.setGPSTime(infoList[3]);
            taxiInfo.setGPSLng(Double.parseDouble(infoList[4]));
            taxiInfo.setGPSLat(Double.parseDouble(infoList[5]));
            taxiInfo.setSpeed(Integer.parseInt(infoList[6]));
            taxiInfo.setOrientation(Integer.parseInt(infoList[7]));
            taxiInfo.setGPSStatus(Integer.parseInt(infoList[8]));
            taxiInfoList.add(taxiInfo);
        }

    }
}

