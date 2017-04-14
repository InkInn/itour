/**
 * 城市
 */
export class City{
    public cityName: string;
    public cityCode: string;
	public proCode: string;
}

/**
 * 省
 */
export class Province{
    public proName: string;
    public proCode: string;
    public cityList: City[];
	public countryCode: string;
	
}

/**
 * 模块
 */
export class Block{
    public name: string;
    public url: string;
}

/**
 * 景点
 */
export class Attraction{
    public name: string;
    public introduc: string;
    public imgUrl: string;
}

/**
 * 游记
 */
export class Note{
    public title: string;
    public outline: string;
    public author: string;
}

/**
 * 用户
 */
export class User{
    public userId: string;
    public loginName: string;
    public password: string;
}