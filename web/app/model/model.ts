/**
 * 城市
 */
export class City{
    public name: string;
    public code: string;
}

/**
 * 省
 */
export class Province{
    public name: string;
    public code: string;
    public citys: City[];
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
export class Tourist{
    public name: string;
    public introduc: string;
    public image: string;
}

/**
 * 游记
 */
export class Note{
    public title: string;
    public outline: string;
    public author: string;
}