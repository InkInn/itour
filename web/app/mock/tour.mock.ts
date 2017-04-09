import {City,Province} from "../model/model";
import {SHANXI,ANHUI} from "../mock/city.mock";

export const PROVINCE: Province[] = [
    {
        proName:'陕西',
        proCode:'01',
        countryCode:'01',
        cityList:SHANXI,
    },
    {
        proName: '安徽',
        proCode: '02',
        countryCode:'01',
        cityList: ANHUI,
    }
]
