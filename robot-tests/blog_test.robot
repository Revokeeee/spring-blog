*** Settings ***
Library    SeleniumLibrary

*** Variables ***
${URL}     http://localhost:8080

*** Test Cases ***
Test Login And Comment
    Sleep    2s
    Open Browser    ${URL}    chrome options=add_argument(--headless);add_argument(--no-sandbox);add_argument(--disable-dev-shm-usage)
    Click Link    Вхід
    Input Text    name=username    Revoke
    Input Text    name=password    123123123
    Sleep    2s
    Click Button    Увійти
    Go Back
    Click Button    Увійти
    Click Element    xpath=(.//*[normalize-space(text())='First Post'])[1]/following::p[1]
    Input Text    name=content    Test comment from Robot Framework
    Click Button    Додати коментар
    Close Browser
